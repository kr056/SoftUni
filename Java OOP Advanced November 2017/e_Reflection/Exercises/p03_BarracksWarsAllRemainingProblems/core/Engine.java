package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core;

import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Executable;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.Repository;
import e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class Engine implements Runnable {

    private static final String COMMANDS_PACKAGE = "e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];

                char firstLetter = Character.toUpperCase(commandName.charAt(0));

                String className = COMMANDS_PACKAGE + firstLetter + commandName.substring(1);

                Class<Executable> exeClass = (Class<Executable>) Class.forName(className);
                Constructor<Executable> constructorCmd = exeClass.getDeclaredConstructor(String[].class,
                        Repository.class, UnitFactory.class);

                constructorCmd.setAccessible(true);

                Executable executable = constructorCmd.newInstance(data, repository, unitFactory);
                String result = executable.execute();

                if ("fight".equals(result)) {
                    break;
                }

                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
