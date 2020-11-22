package pt.iade.unimanager.models;

import java.util.ArrayList;
import java.util.List;

public class UnitRepository {
    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static void populate() {
       
        units.add(new Unit(1,"a",3));
        units.add(new Unit(2,"b",4));
        units.add(new Unit(3,"c", 5));
       
    }

    public static List<Unit> getUnits() {
        return units;
    }

    public static Unit getUnit(int number) {
        for (Unit unit : units) {
            if (unit.getId() == number)
                return unit;
        }
        return null;
    }

    
    
}