package com.example.course_management_system.Service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_management_system.Model.Student;
import com.example.course_management_system.Repositary.studentRepo;
import com.example.course_management_system.ResponseDto.responsedto;
import com.example.course_management_system.ResquestDTO.logindto;
import com.example.course_management_system.ResquestDTO.studentresquestDTO;

@Service
public class studentservice {

    private final studentRepo studentRepo;

    @Autowired
    public studentservice(studentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student register(studentresquestDTO registrationdto) {
        if (registrationdto == null) {
            throw new IllegalArgumentException("Registration data cannot be null");
        }

        if (studentRepo.existsByEmail(registrationdto.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        Student student = new Student();
        student.setName(registrationdto.getName());
        student.setEmail(registrationdto.getEmail());
        student.setPassword(registrationdto.getPassword());

        return studentRepo.save(student);
    }

    public responsedto login(logindto Logindto){
        Student student = new Student();
        student = studentRepo.findByEmail(Logindto.getEmail());

        if(student == null){
            throw new RuntimeException("User is not in our database");
        }

        if(student.getPassword().equals(Logindto.getPassword())){
            responsedto Response = new responsedto();
            Response.setName(student.getName());
            Response.setEmail(student.getEmail());

            return Response;
        }

        return null;
    }
}
