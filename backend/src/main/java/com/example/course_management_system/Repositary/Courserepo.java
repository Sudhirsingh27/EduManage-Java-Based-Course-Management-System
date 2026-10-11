package com.example.course_management_system.Repositary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course_management_system.Model.Course;


public interface Courserepo extends JpaRepository<Course,Long> {
    
}
