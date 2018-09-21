package g_ISPandDIP.Exercises.BoatRacingSimulator;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.*;
import g_ISPandDIP.Exercises.BoatRacingSimulator.controllers.BoatSimulatorControllerImpl;
import g_ISPandDIP.Exercises.BoatRacingSimulator.core.CommandHandlerImpl;
import g_ISPandDIP.Exercises.BoatRacingSimulator.database.BoatSimulatorDatabase;
import g_ISPandDIP.Exercises.BoatRacingSimulator.database.repos.BoatEngineRepository;
import g_ISPandDIP.Exercises.BoatRacingSimulator.database.repos.BoatRepository;
import g_ISPandDIP.Exercises.BoatRacingSimulator.engines.Engine;

import java.io.IOException;
import java.lang.Runnable;

public class Main {
    public static void main(String[] args) throws IOException {
        CrudRepository<Boat> boatCrudRepository = new BoatRepository();
        CrudRepository<BoatEngine> boatEngineCrudRepository = new BoatEngineRepository();
        Database database = new BoatSimulatorDatabase(boatCrudRepository, boatEngineCrudRepository);
        BoatSimulatorController boatSimulatorController = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(boatSimulatorController);
        Runnable engine = new Engine(commandHandler);

        engine.run();
    }
}

