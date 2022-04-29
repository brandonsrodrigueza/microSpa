package com.modulo.spa.service.model;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BathRequest {

	private String petId;
	private String date;
	private ArrayList<String> allergies = new ArrayList<>();
	private ArrayList<String> specifications = new ArrayList<>();
	private ArrayList<String> findings = new ArrayList<>();
	private String status;
}
