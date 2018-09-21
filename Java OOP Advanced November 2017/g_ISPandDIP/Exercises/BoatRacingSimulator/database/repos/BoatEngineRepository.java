package g_ISPandDIP.Exercises.BoatRacingSimulator.database.repos;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.BoatEngine;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.CrudRepository;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.DuplicateModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.NonExistentModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatEngineRepository implements CrudRepository<BoatEngine> {
    private Map<String, BoatEngine> boatEngines;

    public BoatEngineRepository() {
        this.boatEngines = new LinkedHashMap<>();
    }

    @Override
    public BoatEngine getByModel(String model) throws NonExistentModelException {
        if (!this.boatEngines.containsKey(model)) {
            throw new NonExistentModelException(Constants.NonExistentModelMessage);
        }

        return this.boatEngines.get(model);
    }

    @Override
    public void add(BoatEngine item) throws DuplicateModelException {
        if (this.boatEngines.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        this.boatEngines.put(item.getModel(), item);
    }
}
