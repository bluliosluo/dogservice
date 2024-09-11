package org.chloe.demo.dogdocument;

import org.chloe.demo.dto.DogDocumentDto;
import org.springframework.stereotype.Component;

@Component
public class DogDocumentManager {

    public String printDogDocument(DogDocumentDto dogDocumentDto) {
        return "Dog name: " + dogDocumentDto.getName() + ", Dog breed: " + dogDocumentDto.getBreed();
        // return "Dog name: " + dogDocumentDto.getName() + ", Dog breed: " + dogDocumentDto.getBreed().toString();
    }

}
