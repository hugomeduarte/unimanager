package pt.iade.unimanager.models; 
import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {

private static int nextNumber = 0;
private String name;
private LocalDate birthDate;
private String email;
private char gender;
private int number;
private ArrayList<Unit> units;
private ArrayList<Enrolment> enrolments;

public Student(String name, LocalDate birthDate, char gender) { 
    super(name,gender,birthDate);
    this.number = nextNumber; 
    nextNumber++;
    email = "";
    units = new ArrayList <Unit>();
    enrolments = new ArrayList <Enrolment>();
}

    public static int getNextNumber() {
        return nextNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public int getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Unit> getUnits () {
        return units;
    }

    public Enrolment getEnrolmentByUnitId(int unitId) {
        for (Enrolment enr:enrolments) 
        if (enr.getUnit().getId()==unitId) 
        return enr;
        return null;
    }

public void enroll(Unit unit) {
    units.add(unit);
    unit.getStudents().add(this);
}

public ArrayList<Enrolment> getEnrolments() {
    return enrolments;
}

public void enroll(Enrolment enrolment) {
    enrolments.add(enrolment);
    enrolment.getUnit().getEnrolments().add(enrolment);

}


@Override
    public String getReference() {
        return "S<"+number+">";
}






}