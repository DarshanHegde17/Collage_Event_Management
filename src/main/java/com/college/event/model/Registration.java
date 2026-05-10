package com.college.event.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "registrations")
public class Registration {
    @Id
    private String id;
    private String registrationId;
    private String studentId;
    private String studentName;
    private String eventId;
    private String eventName;
    private LocalDateTime registeredAt;
    private String status = "CONFIRMED";
}
