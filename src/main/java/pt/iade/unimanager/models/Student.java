package pt.iade.unimanager.models; 
import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {

private static int nextNumber = 0;
private String email;
private int number;
private ArrayList<Enrolment> enrolments;

public Student(String name,char gender, LocalDate birthDate) { 
    super(name,gender,birthDate);
    this.number = nextNumber; 
    nextNumber++;
    email = "";
    enrolments = new ArrayList <Enrolment>();
}

    public static int getNextNumber() {
        return nextNumber;
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


    public Enrolment getEnrolmentByUnitId(int unitId) {
        for (Enrolment enr:enrolments) 
        if (enr.getUnit().getId()==unitId) 
        return enr;
        return null;
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