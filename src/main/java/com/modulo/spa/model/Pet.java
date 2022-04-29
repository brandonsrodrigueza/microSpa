package com.modulo.spa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pet")
public class Pet {

    @Id
    private String id = String.valueOf(UUID.randomUUID());
    private String name;
    private String breedOfDog;

}
