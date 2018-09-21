package h_ObjectCommunicationAndEvents.Lab.models;

import h_ObjectCommunicationAndEvents.Lab.contracts.Handler;
import h_ObjectCommunicationAndEvents.Lab.contracts.Target;
import h_ObjectCommunicationAndEvents.Lab.enums.LogType;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg, Handler logger) {
        this.getHandler().handle(LogType.ATTACK
                , String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }

    @Override
    public void update(int reward) {
        super.getHandler().handle(LogType.EVENT, super.getId() + " earns " + reward);
    }
}
