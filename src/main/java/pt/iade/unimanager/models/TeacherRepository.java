package pt.iade.unimanager.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
      
        teachers.add(new Teacher("Mary", LocalDate.parse("1999-12-23"), 'F'));
        teachers.add(new Teacher("João", LocalDate.parse("1999-12-20"), 'M'));
        teachers.add(new Teacher("Mário", LocalDate.parse("1999-12-24"), 'M'));
        
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }




    
}