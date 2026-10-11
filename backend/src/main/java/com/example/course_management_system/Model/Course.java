package com.example.course_management_system.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity 
@Data 

public class Course {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Column (nullable = false)
    String name;

    @Column (nullable = false)
    String instructor;

    @Column (nullable = false)
    int duration;

    @Column (nullable = false)
    String status;

    
}
