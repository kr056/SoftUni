package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, NoSuchMethodException
			, InvocationTargetException, InstantiationException, IllegalAccessException;
}
