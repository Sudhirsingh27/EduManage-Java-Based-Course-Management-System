package com.example.course_management_system.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.course_management_system.Model.Student;
import com.example.course_management_system.ResponseDto.responsedto;
import com.example.course_management_system.ResquestDTO.logindto;
import com.example.course_management_system.ResquestDTO.studentresquestDTO;
import com.example.course_management_system.Service.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/students")
@CrossOrigin ("*")
public class studentcontroller {

    @Autowired 
    studentservice studentService;
    
    @PostMapping("/register")
    public Student studentRegister(@RequestBody studentresquestDTO registrationdto)
    {
        return studentService.register(registrationdto);
    }

    @PostMapping ("/login")
    public responsedto studentlogin(@RequestBody logindto Logindto){
        return studentService.login(Logindto);
    }
}
