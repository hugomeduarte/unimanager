package pt.iade.unimanager.models;

import java.util.ArrayList;
import java.time.LocalDate;

public class Teacher extends Person {

    private static int nextNumber = 0;
    private int mecNumber;
    private ArrayList<Unit> units;
    private ArrayList<EnrolmentTeacher> enrolmentsteacher;

    public Teacher(String name, LocalDate birthDay, char gender) {
        super(name, gender, birthDay);
        this.mecNumber=nextNumber;
        nextNumber++;
        units=new ArrayList<Unit>();
        enrolmentsteacher = new ArrayList <EnrolmentTeacher>();
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public int getMecNumber() {
        return mecNumber;
    }

    public EnrolmentTeacher getEnrolmentByUnitId(int unitId) {
        for (EnrolmentTeacher enr:enrolmentsteacher) 
        if (enr.getUnit().getId()==unitId) 
        return enr;
        return null;
    }

public void enroll(Unit unit) {
    units.add(unit);
    unit.getTeachers().add(this);
}

public ArrayList<EnrolmentTeacher> getEnrolmentsTeacher() {
    return enrolmentsteacher;
}

public void enroll(EnrolmentTeacher enrolment) {
    enrolmentsteacher.add(enrolment);
    enrolment.getUnit().getEnrolmentsTeacher().add(enrolment);

}





    @Override
    public String getReference() {
        return "T<"+mecNumber+">";
}




}