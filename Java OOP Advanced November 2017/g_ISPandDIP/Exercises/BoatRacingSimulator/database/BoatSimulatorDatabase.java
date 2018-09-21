package g_ISPandDIP.Exercises.BoatRacingSimulator.database;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Boat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.BoatEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.CrudRepository;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Database;

public class BoatSimulatorDatabase implements Database {
    private CrudRepository<Boat> boats;
    private CrudRepository<BoatEngine> engines;

    public BoatSimulatorDatabase(CrudRepository<Boat> boats, CrudRepository<BoatEngine> engines) {
        this.boats = boats;
        this.engines = engines;
    }

    @Override
    public CrudRepository<Boat> getBoats() {
        return this.boats;
    }

    @Override
    public CrudRepository<BoatEngine> getEngines() {
        return this.engines;
    }

}
