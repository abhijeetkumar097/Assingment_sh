package com.example.Assignment.controller;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Assignment.entity.Incident;
import com.example.Assignment.service.IncidentService;

@RestController
@RequestMapping("/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public ResponseEntity<?> getIncedents() {
        List<Incident> incidents = incidentService.getIncedents();
        if(incidents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addIncident(@RequestBody Incident incident) {
        try {
            if(incident.getSeverity() == null) {
                throw new IllegalArgumentException("Severity must be provided and valid (LOW, MEDIUM, HIGH)");
            }
            incidentService.addIncidents(incident);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidentById(@PathVariable ObjectId id) {
        Optional<Incident> answer = incidentService.getByIncidentId(id);
        if(answer.isPresent()) {
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncidentById(@PathVariable ObjectId id) {
        try {
            incidentService.deleteIncident(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
