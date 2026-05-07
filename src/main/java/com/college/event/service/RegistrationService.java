package com.college.event.service;

import com.college.event.model.Registration;
import com.college.event.model.Event;
import com.college.event.model.Student;
import com.college.event.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private StudentService studentService;
    
    public Registration registerForEvent(String studentId, String eventId) {
        // Check if already registered
        if (registrationRepository.findByStudentIdAndEventId(studentId, eventId).isPresent()) {
            throw new RuntimeException("Already registered for this event");
        }
        
        // Check event capacity
        Event event = eventService.getEventById(eventId);
        if (event == null) {
            throw new RuntimeException("Event not found");
        }
        
        long currentRegistrations = registrationRepository.countByEventId(eventId);
        if (currentRegistrations >= event.getParticipantLimit()) {
            throw new RuntimeException("Event is full");
        }
        
        // Get student details
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        
        // Create registration
        Registration registration = new Registration();
        registration.setRegistrationId("REG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        registration.setStudentId(studentId);
        registration.setStudentName(student.getName());
        registration.setEventId(eventId);
        registration.setEventName(event.getEventName());
        registration.setRegisteredAt(LocalDateTime.now());
        registration.setStatus("CONFIRMED");
        
        // Update event participant count
        eventService.incrementParticipants(eventId);
        
        return registrationRepository.save(registration);
    }
    
    public List<Registration> getStudentRegistrations(String studentId) {
        return registrationRepository.findByStudentId(studentId);
    }
    
    public List<Registration> getEventRegistrations(String eventId) {
        return registrationRepository.findByEventId(eventId);
    }
    
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}
