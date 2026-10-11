package com.example.course_management_system.Repositary;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course_management_system.Model.Student;
import java.util.List;


@Repository
public interface studentRepo extends JpaRepository<Student,Long> {

    Student findByEmail(String email);
}
