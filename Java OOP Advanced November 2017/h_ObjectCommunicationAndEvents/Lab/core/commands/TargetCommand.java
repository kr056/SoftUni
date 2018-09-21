package h_ObjectCommunicationAndEvents.Lab.core.commands;

import h_ObjectCommunicationAndEvents.Lab.contracts.Attacker;
import h_ObjectCommunicationAndEvents.Lab.contracts.Command;
import h_ObjectCommunicationAndEvents.Lab.contracts.Target;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
