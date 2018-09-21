package h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.models;

import h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.interfaces.Killable;

public class Footman extends BaseUnit implements Killable {
    private int health;

    public Footman(String name) {
        super(name);
        this.health = 2;
    }

    @Override
    public void respondToAttack() {
        System.out.println("Footman " + this.toString() + " is panicking!");
    }

    @Override
    public boolean tryToKill() {
        return --this.health <= 0;
    }
}
