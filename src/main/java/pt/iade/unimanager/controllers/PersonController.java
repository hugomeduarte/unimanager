package pt.iade.unimanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanager.models.Person;
import pt.iade.unimanager.models.StudentRepository;
import pt.iade.unimanager.models.TeacherRepository;

@RestController
@RequestMapping(path="/api/persons")

public class PersonController {
 
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
     public List<Person> getPersons() {
        
        ArrayList<Person> persons = getAllPersons();
        return persons;
        // http://localhost:8080/api/persons
    }

    private ArrayList<Person> getAllPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.addAll(StudentRepository.getStudents());
        persons.addAll(TeacherRepository.getTeachers());
        return persons;
    }

/* contém erro

@GetMapping(path = "/search", produces= MediaType.APPLICATION_JSON_VALUE)
public List<Person> searchPersons(@RequestParam(value = "name",defaultValue="") String name,
@RequestParam(value = "email",defaultValue="") String email) {
ArrayList<Person> persons = getAllPersons();
persons.removeIf(
(p) -> !(p.getName().contains(name) && p.getEmail().contains(email)));
    return persons;
}

*/



    
    
    
    






}
