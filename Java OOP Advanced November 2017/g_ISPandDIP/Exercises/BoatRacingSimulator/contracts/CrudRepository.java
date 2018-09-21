package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.DuplicateModelException;
import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.NonExistentModelException;

public interface CrudRepository<T extends Modelable> {

    T getByModel(String model) throws NonExistentModelException;

    void add(T item) throws DuplicateModelException;
}
