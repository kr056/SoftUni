package h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.models;

import h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.interfaces.Killable;

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
