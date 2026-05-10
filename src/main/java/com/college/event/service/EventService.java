package com.college.event.service;

import com.college.event.model.Event;
import com.college.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;
    
    public Event createEvent(Event event) {
        event.setCreatedAt(LocalDateTime.now());
        event.setCurrentParticipants(0);
        return eventRepository.save(event);
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAllByOrderByEventDateDesc();
    }
    
    public Event getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }
    
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
    
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }
    
    public boolean incrementParticipants(String eventId) {
        Event event = getEventById(eventId);
        if (event != null && event.getCurrentParticipants() < event.getParticipantLimit()) {
            event.setCurrentParticipants(event.getCurrentParticipants() + 1);
            eventRepository.save(event);
            return true;
        }
        return false;
    }
}
