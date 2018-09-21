package h_ObjectCommunicationAndEvents.Lab.core.commands;

import h_ObjectCommunicationAndEvents.Lab.contracts.AttackGroup;
import h_ObjectCommunicationAndEvents.Lab.contracts.Command;

public class GroupAttackCommand implements Command {
    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attackGroup) {
        this.attackGroup = attackGroup;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
