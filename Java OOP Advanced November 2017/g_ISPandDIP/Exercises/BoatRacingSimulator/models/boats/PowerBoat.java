package g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.BoatEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Race;

public class PowerBoat extends BaseBoat {
    private BoatEngine firstEngine;
    private BoatEngine secondEngine;

    public PowerBoat(String model, int weight, BoatEngine firstEngine, BoatEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.firstEngine.getCachedOutput() + this.secondEngine.getCachedOutput())
                - super.getWeight() + (race.getOceanCurrentSpeed() / 5.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
