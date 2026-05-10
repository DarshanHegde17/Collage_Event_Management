package com.college.event.service;

import com.college.event.model.Student;
import com.college.event.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public Student register(Student student) {
        if (studentRepository.existsByUsername(student.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (studentRepository.existsByRollNumber(student.getRollNumber())) {
            throw new RuntimeException("Roll number already exists");
        }
        return studentRepository.save(student);
    }
    
    public Student login(String username, String password) {
        return studentRepository.findByUsername(username)
            .filter(student -> student.getPassword().equals(password))
            .orElse(null);
    }
    
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
