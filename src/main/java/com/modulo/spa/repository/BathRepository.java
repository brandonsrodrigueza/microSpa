package com.modulo.spa.repository;

import com.modulo.spa.service.model.BathRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.modulo.spa.model.Bath;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface BathRepository {
    void register(Bath bath);
    void updateStatus(String status, String id);
    void addAllergies(ArrayList<String> allergies, String id);
    void addSpecifications(ArrayList<String> specifications, String id);
    void addfindings(ArrayList<String> findings,String id);
}
