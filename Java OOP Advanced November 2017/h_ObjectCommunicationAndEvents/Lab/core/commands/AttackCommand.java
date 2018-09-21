package h_ObjectCommunicationAndEvents.Lab.core.commands;

import h_ObjectCommunicationAndEvents.Lab.contracts.Attacker;
import h_ObjectCommunicationAndEvents.Lab.contracts.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
