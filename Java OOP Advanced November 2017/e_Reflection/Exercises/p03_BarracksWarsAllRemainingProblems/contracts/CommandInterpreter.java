package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
