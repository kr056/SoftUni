package g_ISPandDIP.Exercises.BoatRacingSimulator.models;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Boat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Race;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.DuplicateModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Constants;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Validator;

import java.util.*;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");

        this.distance = distance;
    }
}