package org.chloe.demo.service;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.EntityNotFoundException;
import org.chloe.demo.dogdocument.DogDocumentManager;
import org.chloe.demo.dto.DogBreed;
import org.chloe.demo.dto.DogDocumentDto;
import org.chloe.demo.dto.ImmutableDogDocumentDto;
import org.chloe.demo.model.DogDocumentModel;
import org.chloe.demo.repository.DogDocumentRepository;
import org.springframework.stereotype.Service;


@Service
public class DogDocumentService {

    private final DogDocumentManager dogDocumentManager;
    private final DogDocumentRepository dogDocumentRepository; // 用于访问数据库

    public DogDocumentService(DogDocumentManager dogDocumentManager, DogDocumentRepository dogDocumentRepository) {
        this.dogDocumentManager = dogDocumentManager;
        this.dogDocumentRepository = dogDocumentRepository;
    }

    public DogDocumentDto getDogDocument(String dogId) {

        // access database to get dog document
        // DogDocumentModel dogDocumentModel = dogDocumentRepository.findById(Long.parseLong(dogId)).orElseThrow();
        DogDocumentModel dogDocumentModel = dogDocumentRepository.findById(Long.parseLong(dogId))
                .orElseThrow(() -> new EntityNotFoundException("Dog with ID " + dogId + " not found"));

        // Convert to DEO
        //        if (dogId.equals("dog-not-found")) {
        //            throw new RuntimeException("Cat not found");
        //        }
        return ImmutableDogDocumentDto.builder()
                .name(dogDocumentModel.getDogName())
                .breed(DogBreed.valueOf(dogDocumentModel.getDogBreed()))
                .build();
    }

    public DogDocumentDto createDogDocument(DogDocumentDto dogDocumentDto) {
        //        if (dogDocumentDto.getName().equals("invalid")) {
        //            throw new RuntimeException("Invalid dog name");
        //        }

        // access database to create a new dog document
        DogDocumentModel dogDocumentModel = DogDocumentModel.Builder.newBuilder()
                .withDogName(dogDocumentDto.getName())
                .withDogBreed(dogDocumentDto.getBreed().name())
                .withCreatedAt(Timestamp.from(Instant.now()))
                .withUpdatedAt(Timestamp.from(Instant.now()))
                .build();

        dogDocumentRepository.save(dogDocumentModel);
        return dogDocumentDto;
    }

}
