package pt.iade.unimanager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import pt.iade.unimanager.models.EnrolmentTeacher;
import pt.iade.unimanager.models.Teacher;
import pt.iade.unimanager.models.TeacherRepository;
import pt.iade.unimanager.models.Unit;
import pt.iade.unimanager.models.UnitRepository;

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

    @GetMapping(path = "{number}/enrolments", produces= MediaType.APPLICATION_JSON_VALUE)
    public  List<EnrolmentTeacher> getEnrolments (@PathVariable("number") int number) throws NotFoundException {
    logger.info("Sending enrolments of teacher with number "+number);
    Teacher teacher = TeacherRepository.getTeacher(number);
    if (teacher != null) {
    return teacher.getEnrolmentsTeacher();
    }
    else throw new NotFoundException(""+number);

    // http://localhost:8080/api/teachers/0/enrolments
    }

    @PostMapping(path = "{number}/enrolments", produces= MediaType.APPLICATION_JSON_VALUE)
        public EnrolmentTeacher addEnrolment(@PathVariable("number") int number, @RequestBody int unitId) throws NotFoundException { 
        Teacher teacher = TeacherRepository.getTeacher(number);
        if (teacher != null) {
        Unit unit = UnitRepository.getUnit(unitId);
        if (unit != null) {
        if (teacher.getEnrolmentByUnitId(unitId)!=null)
        return null;
        else {
        EnrolmentTeacher enrolment = new EnrolmentTeacher(teacher,unit);
        teacher.enroll(enrolment);
        return enrolment;
        }
        } else throw new NotFoundException(""+unitId);
        } else throw new NotFoundException(""+number);
    }

    // falta o delete unit
        










}