package com.example.course_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.course_management_system.Model.Student;
import com.example.course_management_system.ResquestDTO.studentresquestDTO;
import com.example.course_management_system.Service.studentservice;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private studentservice studentservice;

    @Test
    void register_should_create_student_and_return_saved_student() {
        studentresquestDTO dto = new studentresquestDTO();
        dto.setName("Alice");
        dto.setEmail("alice@example.com");
        dto.setPassword("secret");

        Student saved = studentservice.register(dto);

        assertNotNull(saved);
        assertEquals("Alice", saved.getName());
        assertEquals("alice@example.com", saved.getEmail());
        assertEquals("secret", saved.getPassword());
        assertNotNull(saved.getId());
    }
}
