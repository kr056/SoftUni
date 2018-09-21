package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.commands;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Repository;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Fight extends Command {

    protected Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
