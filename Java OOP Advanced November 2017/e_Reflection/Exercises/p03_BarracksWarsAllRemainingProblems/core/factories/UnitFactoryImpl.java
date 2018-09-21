package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.factories;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Unit;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor constructor = unitClass.getDeclaredConstructor();

        return (Unit) constructor.newInstance();
    }
}
