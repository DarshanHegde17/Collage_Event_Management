package com.college.event.service;

import com.college.event.model.Admin;
import com.college.event.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    @PostConstruct
    public void initAdmin() {
        // Create default admin if not exists
        if (!adminRepository.existsByUsername("nit")) {
            Admin admin = new Admin();
            admin.setUsername("nit");
            admin.setPassword("nit");
            admin.setEmail("admin@nit.edu");
            admin.setRole("ADMIN");
            adminRepository.save(admin);
            System.out.println("Default admin created: username=nit, password=nit");
        }
    }
    
    public Admin login(String username, String password) {
        return adminRepository.findByUsername(username)
            .filter(admin -> admin.getPassword().equals(password))
            .orElse(null);
    }
}
