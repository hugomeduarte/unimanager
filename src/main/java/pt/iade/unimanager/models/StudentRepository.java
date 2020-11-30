package pt.iade.unimanager.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static ArrayList<Student> students = new ArrayList<Student>();

    public static void populate() {
        students.add(new Student("Mary", 'F', LocalDate.parse("1999-12-23")));
        students.add(new Student("Joao", 'M', LocalDate.parse("1999-12-20")));
        students.add(new Student("Mario", 'M', LocalDate.parse("1999-12-24")));
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static Student getStudent(int number) {
        for (Student student : students) {
            if (student.getNumber() == number)
                return student;
        }
        return null;
    }

    public static Boolean deleteStudent(int number) {
        return students.removeIf((s) -> s.getNumber() == number);
    }

    public static Student addStudent(Student student) {
        students.add(student);
        return student;
    }
    
}