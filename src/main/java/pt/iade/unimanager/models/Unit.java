package pt.iade.unimanager.models; 

import java.util.ArrayList;

public class Unit {
    private int id;
    private String name;
    private int credits;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Enrolment> enrolments;
    private ArrayList<EnrolmentTeacher> enrolmentsteacher;

    public Unit(int id, String name, int credits) {
        this.id=id;
        this.name=name;
        this.credits=credits;
        students = new ArrayList <Student>();
        enrolments = new ArrayList <Enrolment>();
        enrolmentsteacher = new ArrayList <EnrolmentTeacher>();
        teachers = new ArrayList <Teacher>();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public ArrayList<EnrolmentTeacher> getEnrolmentsTeacher() {
        return enrolmentsteacher;
    }


    









}