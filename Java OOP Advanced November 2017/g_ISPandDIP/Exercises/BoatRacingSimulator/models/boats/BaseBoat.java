package g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats;


import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Boat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Constants;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Validator;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    protected int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

}
