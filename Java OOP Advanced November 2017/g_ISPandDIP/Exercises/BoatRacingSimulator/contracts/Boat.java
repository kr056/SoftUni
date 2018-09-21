package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

public interface Boat extends Modelable{
    double calculateRaceSpeed(Race race);

    boolean hasEngine();
}
