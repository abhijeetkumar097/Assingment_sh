package com.example.Assignment.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Assignment.entity.Incident;

@Repository
public interface IncidentRepo extends MongoRepository<Incident, ObjectId> {
    
}
