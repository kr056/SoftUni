package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Repository;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.Engine;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.factories.UnitFactoryImpl;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
