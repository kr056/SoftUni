package g_ISPandDIP.Exercises.BoatRacingSimulator.controllers;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.*;
import g_ISPandDIP.Exercises.BoatRacingSimulator.enumeration.EngineType;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.*;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.RaceImpl;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boatEngines.JetEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boatEngines.SterndriveEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats.PowerBoat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats.RowBoat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats.SailBoat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.models.boats.Yacht;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    private Database database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(Database database) {
        this.database = database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType)
            throws DuplicateModelException {
        EngineType type = null;

        try {
            type = EngineType.valueOf(engineType.toUpperCase());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IncorrectEngineTypeException(Constants.IncorrectEngineTypeMessage);
        }

        BoatEngine engine = null;

        switch (type) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().add(engine);

        StringBuilder sb = new StringBuilder();
        sb.append("Engine model ").append(model).append(" with ").append(horsepower)
                .append(" HP and displacement ").append(displacement).append(" cm3 created successfully.");

        return sb.toString();
    }

    @Override
    public String createRowBoat(String model, int weight, int oars)
            throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);

        this.database.getBoats().add(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Row boat with model ").append(model).append(" registered successfully.");

        return sb.toString();
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency)
            throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);

        this.database.getBoats().add(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Sail boat with model ").append(model).append(" registered successfully.");

        return sb.toString();
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
            throws NonExistentModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().getByModel(firstEngineModel);

        BoatEngine secondEngine = this.database.getEngines().getByModel(secondEngineModel);

        Boat boat = new PowerBoat(model, weight, firstEngine, secondEngine);

        this.database.getBoats().add(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Power boat with model ").append(model).append(" registered successfully.");

        return sb.toString();
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargo)
            throws NonExistentModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().getByModel(engineModel);

        Boat boat = new Yacht(model, weight, engine, cargo);

        this.database.getBoats().add(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Yacht with model ").append(model).append(" registered successfully.");

        return sb.toString();
    }

    @Override
    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }

        Race boatRace = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.currentRace = boatRace;

        StringBuilder sb = new StringBuilder();
        sb.append("A new race with distance ").append(distance).append(" meters, wind speed ")
                .append(windSpeed).append(" m/s and ocean current speed ").append(oceanCurrentSpeed)
                .append(" m/s has been set.");

        return sb.toString();
    }

    @Override
    public String signUpBoat(String model)
            throws NonExistentModelException, DuplicateModelException, NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        Boat boat = this.database.getBoats().getByModel(model);

        if (!this.currentRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }

        this.currentRace.addParticipant(boat);

        StringBuilder sb = new StringBuilder();
        sb.append("Boat with model ").append(model).append(" has signed up for the current Race.");

        return sb.toString();
    }

    @Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<Boat> participants = this.currentRace.getParticipants();

        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<Boat> bySpeedDescending = (b1, b2) -> {
            double s1 = b1.calculateRaceSpeed(this.currentRace);
            double s2 = b2.calculateRaceSpeed(this.currentRace);

            if (s1 < 0 && s2 < 0) {
                return 0;
            }

            return Double.compare(s2, s1);
        };

        List<Boat> winners = participants.stream()
                .sorted(bySpeedDescending)
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        int placeCounter = 1;

        for (Boat winner : winners) {
            double speed = winner.calculateRaceSpeed(this.currentRace);
            double time = this.currentRace.getDistance() / speed;

            result.append(placeCounter == 1 ? "First" : placeCounter == 2 ? "Second" : "Third")
                    .append(" place: ").append(winner.getClass().getSimpleName())
                    .append(" Model: ").append(winner.getModel())
                    .append(" Time: ").append(speed <= 0D ? "Did not finish!" : String.format("%.2f sec", time))
                    .append(System.lineSeparator());
            placeCounter++;
        }

        this.currentRace = null;
        return result.toString().trim();
    }

    @Override
    public String getStatistics() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<Boat> participants = this.currentRace.getParticipants();
        Map<String, List<Boat>> participantsByBoatType = participants.stream().collect(Collectors.groupingBy((p) -> p.getClass().getSimpleName()));
        int totalParticipants = participantsByBoatType.values().stream().mapToInt((p) -> p.size()).sum();

        StringBuilder sb = new StringBuilder();

        participantsByBoatType.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach((e) -> {
                    sb.append(String.format("%s -> %.2f", e.getKey(), 100D * e.getValue().size() / totalParticipants));
                    sb.append("%").append(System.lineSeparator());
                });

        return sb.toString().trim();
    }


    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
