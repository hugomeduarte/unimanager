package pt.iade.unimanager.models;

public class EnrolmentTeacher {

    private Teacher teacher;
    private Unit unit;

    public EnrolmentTeacher(Teacher teacher, Unit unit) {
        this.teacher=teacher;
        this.unit=unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public Teacher getTeacher() {
        return teacher;
    }


}
