package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import java.util.List;
import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Mission;

public interface ICommando extends ISpecialisedSoldier {
    void addMission(Mission mission);

    List<Mission> getMissions();
}
