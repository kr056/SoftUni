package e_Reflection.Exercises.p03_BarracksWarsAllRemainingProblems.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String removeUnit(String unitType);
}
