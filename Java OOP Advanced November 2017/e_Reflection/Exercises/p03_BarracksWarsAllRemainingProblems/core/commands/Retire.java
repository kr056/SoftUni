package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.commands;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Repository;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {

    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = this.getData()[1];

        return this.getRepository().removeUnit(unitType);
    }
}
