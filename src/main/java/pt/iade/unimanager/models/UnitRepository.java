package pt.iade.unimanager.models;

import java.util.ArrayList;
import java.util.List;

public class UnitRepository {
    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static void populate() {
       
        units.add(new Unit(1,"Mat",3));
        units.add(new Unit(2,"Hist",4));
        units.add(new Unit(3,"Progr", 5));
       
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