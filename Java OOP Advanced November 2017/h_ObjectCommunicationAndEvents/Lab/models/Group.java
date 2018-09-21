package h_ObjectCommunicationAndEvents.Lab.models;

import h_ObjectCommunicationAndEvents.Lab.contracts.AttackGroup;
import h_ObjectCommunicationAndEvents.Lab.contracts.Attacker;
import h_ObjectCommunicationAndEvents.Lab.contracts.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group() {
        this.attackers=new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        this.attackers.forEach(x->x.setTarget(target));
    }

    @Override
    public void groupAttack() {
        attackers.forEach(Attacker::attack);
    }
}
