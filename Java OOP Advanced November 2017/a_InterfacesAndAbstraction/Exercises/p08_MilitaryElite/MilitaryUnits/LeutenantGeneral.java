package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    private List<Private> orderPrivates() {
        return this.privates = this.privates.stream()
                .sorted(Comparator.comparingInt(Soldier::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void add(Private p) {
        this.privates.add(p);
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Privates:").append("\n");
        this.orderPrivates().forEach(p -> sb.append("  ").append(p.toString()));

        return sb.toString();
    }
}
