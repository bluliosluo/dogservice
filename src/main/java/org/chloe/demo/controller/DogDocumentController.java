package org.chloe.demo.controller;

import org.chloe.demo.dto.DogDocumentDto;
import org.chloe.demo.dto.ImmutableDogDocumentDto;
import org.chloe.demo.service.DogDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DogDocumentController {

    private final DogDocumentService dogDocumentService;

    public DogDocumentController(DogDocumentService dogDocumentService) {
        this.dogDocumentService = dogDocumentService;
    }

    // pass data through a @PathVariable
    @GetMapping("/hello-dog/{dog-name}")
    public ResponseEntity<String> helloDog(@PathVariable("dog-name") String dogName   ) {
        // return "hello " + dogName + "!";
        String returnMsg = "Hello " + dogName + "!";
        if (dogName.equals("server-down")) {
            return ResponseEntity.status(500).body("Server is down");
        }

        if (dogName.equals("not-found")) {
            return ResponseEntity.notFound().build();
        }

        if (dogName.equals("invalid")) {
            return ResponseEntity.badRequest().body("Invalid dog name");
        }
        return ResponseEntity.ok(returnMsg);
    }


    // Using DTO
    @GetMapping("/dog-document/{dog-id}")
    public ResponseEntity<DogDocumentDto> getDogDocument(@PathVariable("dog-id") String dogId) {
        //        DogBreed dogBreed = dto.getBreed();
        //        String dogName = dto.getName();
        //
        //        System.out.println("Dog breed: " + dogBreed);
        DogDocumentDto dogDocumentDto;
        try {
            dogDocumentDto = dogDocumentService.getDogDocument(dogId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(dogDocumentDto);
    }

    @PostMapping("/dog-document")
    public ResponseEntity<DogDocumentDto> createDogDocument(@RequestBody DogDocumentDto dogDocumentDto) {
        try {
            dogDocumentService.createDogDocument(dogDocumentDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ImmutableDogDocumentDto.builder()
            .name(dogDocumentDto.getName())
            .breed(dogDocumentDto.getBreed())
            .build());
    }
}
