package pt.iade.unimanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import pt.iade.unimanager.models.Teacher;
import pt.iade.unimanager.models.TeacherRepository;
import pt.iade.unimanager.models.Unit;

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

    @GetMapping(path = "{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacher(@PathVariable("number") int number)  {
        logger.info("Sending specific teacher");
        return TeacherRepository.getTeacher(number);
        
        // http://localhost:8080/api/teachers/0
    }

    @GetMapping(path = "{mecNumber}/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Unit> getUnits(@PathVariable("mecNumber") int mecNumber) throws NotFoundException {
        logger.info("Sending units of the teacher by mecNumber " + mecNumber);
        Teacher teacher = TeacherRepository.getTeacher(mecNumber);

            return teacher.getUnits();

    }
        










}