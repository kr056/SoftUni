package g_ISPandDIP.Exercises.BoatRacingSimulator.database.repos;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.Boat;
import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.CrudRepository;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.DuplicateModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.NonExistentModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.utility.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoatRepository implements CrudRepository<Boat> {
    private Map<String, Boat> boats;

    public BoatRepository() {
        this.boats = new LinkedHashMap<>();
    }


    @Override
    public void add(Boat item) throws DuplicateModelException {
        if (this.boats.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }

        this.boats.put(item.getModel(), item);
    }

    @Override
    public Boat getByModel(String model) throws NonExistentModelException {
        if (!this.boats.containsKey(model)) {
            throw new NonExistentModelException(Constants.NonExistentModelMessage);
        }

        return this.boats.get(model);
    }


}
