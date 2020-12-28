package pt.iade.unimanager.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
      
        teachers.add(new Teacher("Mary", LocalDate.parse("1999-12-23"), 'F'));
        teachers.add(new Teacher("Joao", LocalDate.parse("1999-12-20"), 'M'));
        teachers.add(new Teacher("Mario", LocalDate.parse("1999-12-24"), 'M'));
        
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public static Teacher getTeacher(int number) {

        for (Teacher teacher:teachers) {
            if(teacher.getMecNumber()==number)
            return teacher; 
        }
        return null;
    }

    public static ArrayList<Unit> getUnitsFromTeacher(int number) {
        for (Teacher teacher:teachers) {
            if(teacher.getMecNumber()==number)
            return teacher.getUnits(); 
        }
        return null;
    }


}