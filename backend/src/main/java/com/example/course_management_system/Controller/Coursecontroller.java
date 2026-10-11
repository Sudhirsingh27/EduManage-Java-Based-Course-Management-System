package com.example.course_management_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_management_system.Model.Course;
import com.example.course_management_system.ResquestDTO.CourseDto;
import com.example.course_management_system.Service.Courseservice;

@RestController 
@RequestMapping ("/course")
@CrossOrigin ("*")
public class Coursecontroller {

    @Autowired 
    Courseservice courseservice;

    @PostMapping ("/create")
    public Course  createcourse(@RequestBody CourseDto courseDto){
        return courseservice.createcourse(courseDto);
    }

    @GetMapping ("/all")
    public  List<Course> getallCourses(){
        return  courseservice.getallCourses();
    }
    
}
