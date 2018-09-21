package g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.BoatEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Race;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Validator;

public class Yacht extends BaseBoat {
    private BoatEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BoatEngine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.engine.getCachedOutput() - (super.getWeight() + this.cargoWeight)
                + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
