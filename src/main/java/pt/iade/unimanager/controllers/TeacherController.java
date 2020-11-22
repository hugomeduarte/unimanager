package pt.iade.unimanager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager.models.Teacher;
import pt.iade.unimanager.models.TeacherRepository;

@RestController
@RequestMapping(path="/api/teachers")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeachers() {
        logger.info("Sending all teachers");
        return TeacherRepository.getTeachers();
        
        // http://localhost:8080/api/teachers
    }










}