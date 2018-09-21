package h_ObjectCommunicationAndEvents.Lab;

import h_ObjectCommunicationAndEvents.Lab.core.commands.AttackCommand;
import h_ObjectCommunicationAndEvents.Lab.core.commands.GroupAttackCommand;
import h_ObjectCommunicationAndEvents.Lab.core.commands.GroupTargetCommand;
import h_ObjectCommunicationAndEvents.Lab.core.commands.TargetCommand;
import h_ObjectCommunicationAndEvents.Lab.contracts.*;
import h_ObjectCommunicationAndEvents.Lab.core.CommandExecutor;
import h_ObjectCommunicationAndEvents.Lab.models.AbstractHero;
import h_ObjectCommunicationAndEvents.Lab.models.Dragon;
import h_ObjectCommunicationAndEvents.Lab.models.Group;
import h_ObjectCommunicationAndEvents.Lab.models.Warrior;
import h_ObjectCommunicationAndEvents.Lab.models.loggers.CombatLogger;
import h_ObjectCommunicationAndEvents.Lab.models.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();
        combatLogger.setSuccessor(eventLogger);

//        Attacker attacker = new Warrior("dumbo",55,combatLogger);
//        Target target = new Dragon("Drago",50,1000,combatLogger);

        AttackGroup attackGroup = new Group();
//        attackGroup.addMember(new Warrior("dumbo",55,combatLogger));
//        attackGroup.addMember(new Warrior("dumbo2",55,combatLogger));
        Target groupTarget = new Dragon("Drago", 250, 1000, combatLogger);

        Executor commandExecutor = new CommandExecutor();
//        Command setTargetCommand = new TargetCommand(attacker,target);
//        Command attackCommand = new AttackCommand(attacker);
//        commandExecutor.executeCommand(setTargetCommand);
//        commandExecutor.executeCommand(attackCommand);

//        attacker.setTarget(target);
//        attacker.attack();


        AbstractHero attacker1 = new Warrior("dumbo1", 55, combatLogger);
        AbstractHero attacker2 = new Warrior("dumbo2", 55, combatLogger);
        AbstractHero attacker3 = new Warrior("dumbo3", 55, combatLogger);
        AbstractHero attacker4 = new Warrior("dumbo4", 55, combatLogger);
        AbstractHero attacker5 = new Warrior("dumbo5", 55, combatLogger);
        Dragon dragon = new Dragon("Drago", 250, 1000, combatLogger);

        attackGroup.addMember(attacker1);
        attackGroup.addMember(attacker2);
        attackGroup.addMember(attacker3);
        attackGroup.addMember(attacker4);
        attackGroup.addMember(attacker5);

        dragon.register(attacker1);
        dragon.register(attacker2);
        dragon.register(attacker3);
        dragon.register(attacker4);
        dragon.register(attacker5);

        Command groupTargetCommand = new GroupTargetCommand(attackGroup, dragon);
        Command groupAttackCommand = new GroupAttackCommand(attackGroup);
        commandExecutor.executeCommand(groupTargetCommand);
        commandExecutor.executeCommand(groupAttackCommand);

    }
}
