package com.example.course_management_system.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_management_system.Model.Course;
import com.example.course_management_system.Model.Enrollment;
import com.example.course_management_system.Model.Student;
import com.example.course_management_system.Repositary.Courserepo;
import com.example.course_management_system.Repositary.EnrollmentRepo;
import com.example.course_management_system.Repositary.studentRepo;
import com.example.course_management_system.ResquestDTO.Enrollmentdto;

@Service 
public class Enrollmentservice {

    @Autowired 
    studentRepo studentrepo;

    @Autowired 
    EnrollmentRepo enrollmentrepo;

    @Autowired 
    Courserepo courserepo;

    public Enrollment enroll(Enrollmentdto dto){
        Student student = studentrepo.findByEmail(dto.getStudentemail());
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        Course course =  courserepo.findById(dto.getCourseid()).orElseThrow();
        enrollment.setCourse(course);
        enrollment.setEnrolledate(LocalDate.now());

        return enrollmentrepo.save(enrollment);
    }
}
