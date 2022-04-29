package com.modulo.spa.service;


import com.modulo.spa.repository.BathRepositoryImpl;
import com.modulo.spa.service.model.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.modulo.spa.model.Bath;
import com.modulo.spa.service.model.BathRequest;

import java.util.ArrayList;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@Service
public class BathService{

	@Autowired
	BathRepositoryImpl bathRepositoryImpl;

	ResponseDTO responseDTO = new ResponseDTO();
	Bath bathEntity = new Bath();

	public ResponseEntity<Object> register(BathRequest bath){
		bathEntity.setDate(bath.getDate());
		bathEntity.setPetId(bath.getPetId());
		bathEntity.setFindings(bath.getFindings());
		bathEntity.setAllergies(bath.getAllergies());
		bathEntity.setStatus("registered");
		bathRepositoryImpl.register(bathEntity);
		responseDTO.setMessage("The bath was successfully registered");
		responseDTO.setCode(HttpStatus.OK.toString());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}


	public ResponseEntity<Object> updateStatus(BathRequest bathRequest, String id) {
		bathRepositoryImpl.updateStatus(bathRequest.getStatus(),id);
		responseDTO.setMessage("Status updated");
		responseDTO.setCode(HttpStatus.OK.toString());

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	public ResponseEntity<Object> addAllergies(BathRequest bathRequest, String id) {
		bathRepositoryImpl.addAllergies(bathRequest.getAllergies(), id);
		responseDTO.setMessage("Allergy successfully added ");
		responseDTO.setCode(HttpStatus.OK.toString());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	public ResponseEntity<Object> addSpecifications(BathRequest bathRequest, String id) {
		bathRepositoryImpl.addSpecifications(bathRequest.getSpecifications(), id);
		responseDTO.setMessage("Specification successfully added");
		responseDTO.setCode(HttpStatus.OK.toString());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	public ResponseEntity<Object> addFindings(BathRequest bathRequest, String id) {
		bathRepositoryImpl.addfindings(bathRequest.getFindings(), id);
		responseDTO.setMessage("Finding successfully added");
		responseDTO.setCode(HttpStatus.OK.toString());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}




}

