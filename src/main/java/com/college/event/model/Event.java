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
@Document(collection = "events")
public class Event {
    @Id
    private String id;
    private String eventName;
    private String description;
    private String venue;
    private LocalDateTime eventDate;
    private int participantLimit;
    private int currentParticipants = 0;
    private String createdBy;
    private LocalDateTime createdAt;
}
