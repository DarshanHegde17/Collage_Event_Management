package com.college.event.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String rollNumber;
    private String department;
    private String year;
    private String role = "STUDENT";
}
