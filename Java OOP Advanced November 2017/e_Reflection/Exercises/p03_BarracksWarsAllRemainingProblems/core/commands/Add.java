package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.commands;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Repository;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Unit;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);

        return unitType + " added!";
    }
}
