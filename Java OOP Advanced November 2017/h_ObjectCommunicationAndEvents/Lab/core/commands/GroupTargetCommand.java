package h_ObjectCommunicationAndEvents.Lab.core.commands;

import h_ObjectCommunicationAndEvents.Lab.contracts.AttackGroup;
import h_ObjectCommunicationAndEvents.Lab.contracts.Command;
import h_ObjectCommunicationAndEvents.Lab.contracts.Target;

public class GroupTargetCommand implements Command {
    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attackGroup, Target target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
