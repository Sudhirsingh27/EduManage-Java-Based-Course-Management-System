package com.example.course_management_system.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_management_system.Model.Enrollment;
import com.example.course_management_system.ResquestDTO.Enrollmentdto;
import com.example.course_management_system.Service.Enrollmentservice;

@RestController 
@RequestMapping ("/enrollment")
@CrossOrigin ("*")
public class Enrollmentcontroller {

    @Autowired 
    Enrollmentservice enrollmentservice;

    @PostMapping ("/create")
    public Enrollment enrollment(@RequestBody Enrollmentdto enrollmrntdto){
        return enrollmentservice.enroll(enrollmrntdto);
    }
}
