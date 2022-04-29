package com.modulo.spa.repository;

import com.modulo.spa.model.Bath;
import com.modulo.spa.model.Pet;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class BathRepositoryImpl implements BathRepository {

    Log logger = LogFactory.getLog(BathRepositoryImpl.class);
    private MongoTemplate mongoTemplate;
    private Bath bath = new Bath();
    public BathRepositoryImpl(MongoTemplate mongoTemplate){this.mongoTemplate = mongoTemplate;}

    @Override
    public void register(Bath bath) {
        mongoTemplate.save(bath);
    }

    @Override
    public void updateStatus(String status, String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        logger.info(id);
        logger.info(mongoTemplate.findOne(query, Pet.class));
        mongoTemplate.updateFirst(query, Update.update("status",status),Bath.class);
    }

    @Override
    public void addAllergies(ArrayList<String> allergies, String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        bath = mongoTemplate.findOne(query, Bath.class);
        bath.getAllergies().addAll(allergies);
        mongoTemplate.updateFirst(query, Update.update("allergies", bath.getAllergies()),Bath.class);
    }

    @Override
    public void addSpecifications(ArrayList<String> specifications,String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        bath = mongoTemplate.findOne(query, Bath.class);
        bath.getSpecifications().addAll(specifications);
        mongoTemplate.updateFirst(query, Update.update("specifications", bath.getSpecifications()),Bath.class);
    }

    @Override
    public void addfindings(ArrayList<String> findings, String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        bath = mongoTemplate.findOne(query, Bath.class);
        bath.getFindings().addAll(findings);
        mongoTemplate.updateFirst(query, Update.update("findings", bath.getFindings()),Bath.class);
    }

}
