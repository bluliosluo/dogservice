package org.chloe.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;


@Value.Immutable
@JsonSerialize(as = ImmutableDogDocumentDto.class)
@JsonDeserialize(as = ImmutableDogDocumentDto.class)
public interface DogDocumentDto {
    @JsonProperty("dog_name")
    String getName();
    @JsonProperty("dog_breed")
    DogBreed getBreed();
}