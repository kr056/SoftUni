package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import java.util.List;

public interface ILeutenantGeneral extends ISoldier {

    void add(Private p);

    List<Private> getPrivates();

}
