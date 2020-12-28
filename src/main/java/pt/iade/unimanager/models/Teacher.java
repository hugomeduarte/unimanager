package pt.iade.unimanager.models;

import java.util.ArrayList;
import java.time.LocalDate;

public class Teacher extends Person {

    private static int nextNumber = 0;
    private int mecNumber;
    private ArrayList<Unit> units;

    public Teacher(String name, LocalDate birthDay, char gender) {
        super(name, gender, birthDay);
        this.mecNumber=nextNumber;
        nextNumber++;
        units=new ArrayList<Unit>();
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public int getMecNumber() {
        return mecNumber;
    }


    @Override
    public String getReference() {
        return "T<"+mecNumber+">";
}



}