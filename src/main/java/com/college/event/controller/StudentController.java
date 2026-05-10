package com.college.event.controller;

import com.college.event.model.Student;
import com.college.event.model.Registration;
import com.college.event.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private RegistrationService registrationService;
    
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> register(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            Student registeredStudent = studentService.register(student);
            response.put("success", true);
            response.put("message", "Registration successful! Please login.");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        String username = credentials.get("username");
        String password = credentials.get("password");
        
        Student student = studentService.login(username, password);
        
        if (student != null) {
            session.setAttribute("studentId", student.getId());
            session.setAttribute("studentName", student.getName());
            session.setAttribute("userType", "STUDENT");
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
        if (session.getAttribute("studentId") == null) {
            return "redirect:/student/login";
        }
        
        model.addAttribute("studentName", session.getAttribute("studentName"));
        model.addAttribute("events", eventService.getAllEvents());
        return "student-dashboard";
    }
    
    @PostMapping("/event/register/{eventId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> registerForEvent(@PathVariable String eventId, HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        
        String studentId = (String) session.getAttribute("studentId");
        if (studentId == null) {
            response.put("success", false);
            response.put("message", "Please login first");
            return ResponseEntity.ok(response);
        }
        
        try {
            Registration registration = registrationService.registerForEvent(studentId, eventId);
            response.put("success", true);
            response.put("message", "Registration successful!");
            response.put("registrationId", registration.getRegistrationId());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/registrations")
    @ResponseBody
    public ResponseEntity<?> getMyRegistrations(HttpSession session) {
        String studentId = (String) session.getAttribute("studentId");
        if (studentId == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        return ResponseEntity.ok(registrationService.getStudentRegistrations(studentId));
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
