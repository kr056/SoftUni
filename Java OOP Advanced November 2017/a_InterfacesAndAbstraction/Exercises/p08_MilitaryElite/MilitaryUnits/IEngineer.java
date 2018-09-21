package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Repair;
import java.util.List;

public interface IEngineer extends ISpecialisedSoldier{

    void addRepair(Repair repair);

    List<Repair> getRepairList();
}
