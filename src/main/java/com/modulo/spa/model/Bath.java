package com.modulo.spa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "bath")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bath {

	@Id
	private String id = String.valueOf(UUID.randomUUID());
	private String petId;
	private String date;
	private ArrayList<String> allergies = new ArrayList<>();
	private ArrayList<String> specifications = new ArrayList<>();
	private ArrayList<String> findings = new ArrayList<>();
	private String status;
}
