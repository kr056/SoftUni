package g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Race;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Validator;

public class RowBoat extends BaseBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.oars * 100.0) - super.getWeight() + race.getOceanCurrentSpeed();
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}
