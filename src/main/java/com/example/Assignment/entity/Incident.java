package com.example.Assignment.entity;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.Assignment.enums.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "incident")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {

    @Id
    private ObjectId id;
    private String title;
    private String description;
    private Severity severity;
    private LocalDateTime reportedAt;

    public Incident(String title, String description, Severity severity, LocalDateTime reportedAt) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.reportedAt = reportedAt;
    }
}
