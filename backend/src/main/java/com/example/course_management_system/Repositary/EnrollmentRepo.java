package com.example.course_management_system.Repositary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course_management_system.Model.Enrollment;

@Repository 
public interface EnrollmentRepo extends JpaRepository<Enrollment,Long> {
   
}
