package com.example.Assignment.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Assignment.entity.Incident;
import com.example.Assignment.repository.IncidentRepo;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepo incidentRepo;

    public List<Incident> getIncedents() {
        return incidentRepo.findAll();
    }

    public void addIncidents(Incident incident) {
        incident.setReportedAt(LocalDateTime.now());
        incidentRepo.save(incident);
    }

    public Optional<Incident> getByIncidentId(ObjectId objectId) {
        return incidentRepo.findById(objectId);
    }

    public void deleteIncident(ObjectId objectId) {
        Optional<Incident> answer = incidentRepo.findById(objectId);
        if(!answer.isPresent()) {
            throw new RuntimeException("Incident not found");
        }
        incidentRepo.deleteById(objectId);
    }
}
