package com.college.event.controller;

import com.college.event.model.Admin;
import com.college.event.model.Event;
import com.college.event.service.AdminService;
import com.college.event.service.EventService;
import com.college.event.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private RegistrationService registrationService;
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        String username = credentials.get("username");
        String password = credentials.get("password");
        
        Admin admin = adminService.login(username, password);
        
        if (admin != null) {
            session.setAttribute("adminId", admin.getId());
            session.setAttribute("adminUsername", admin.getUsername());
            session.setAttribute("userType", "ADMIN");
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null) {
            return "redirect:/admin/login";
        }
        
        model.addAttribute("username", session.getAttribute("adminUsername"));
        model.addAttribute("events", eventService.getAllEvents());
        return "admin-dashboard";
    }
    
    @PostMapping("/event/create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody Event event, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        if (session.getAttribute("adminId") == null) {
            response.put("success", false);
            response.put("message", "Unauthorized");
            return ResponseEntity.ok(response);
        }
        
        try {
            event.setCreatedBy((String) session.getAttribute("adminUsername"));
            Event createdEvent = eventService.createEvent(event);
            response.put("success", true);
            response.put("message", "Event created successfully");
            response.put("event", createdEvent);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/event/delete/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteEvent(@PathVariable String id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        if (session.getAttribute("adminId") == null) {
            response.put("success", false);
            response.put("message", "Unauthorized");
            return ResponseEntity.ok(response);
        }
        
        try {
            eventService.deleteEvent(id);
            response.put("success", true);
            response.put("message", "Event deleted successfully");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/registrations")
    @ResponseBody
    public ResponseEntity<?> getAllRegistrations(HttpSession session) {
        if (session.getAttribute("adminId") == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }
    
    @GetMapping("/events")
    @ResponseBody
    public ResponseEntity<?> getAllEvents(HttpSession session) {
        if (session.getAttribute("adminId") == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        return ResponseEntity.ok(eventService.getAllEvents());
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
