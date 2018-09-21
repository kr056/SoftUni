package h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.models;

import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.interfaces.Killable;

public class RoyalGuard extends BaseUnit implements Killable {
    private int health;

    public RoyalGuard(String name) {
        super(name);
        this.health = 3;
    }

    @Override
    public void respondToAttack() {
        System.out.println("Royal Guard " + this.toString() + " is defending!");
    }

    @Override
    public boolean tryToKill() {
        return --this.health <= 0;
    }
}
