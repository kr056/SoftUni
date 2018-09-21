package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Repair;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer  {
    private List<Repair> repairList;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairList=new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairList.add(repair);
    }

    @Override
    public List<Repair> getRepairList() {
        return this.repairList;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Corps: %s%n",this.getCorps()));
        sb.append("Repairs:").append("\n");
        this.getRepairList().forEach(p->sb.append(p.toString()));

        return sb.toString();
    }
}
