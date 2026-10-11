package com.example.course_management_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.course_management_system.Model.Course;
import com.example.course_management_system.Repositary.Courserepo;
import com.example.course_management_system.ResquestDTO.CourseDto;

@Service 
public class Courseservice {


    @Autowired 
    Courserepo courserepo;
    
    public Course createcourse(CourseDto courseDto){
        Course course = new Course();

        course.setName(courseDto.getName());
        course.setInstructor(courseDto.getInstructor());
        course.setDuration(courseDto.getDuration());
        course.setStatus(courseDto.getStatus());

        return courserepo.save(course);
    }

    public List<Course> getallCourses(){
        return courserepo.findAll();
    }
}
