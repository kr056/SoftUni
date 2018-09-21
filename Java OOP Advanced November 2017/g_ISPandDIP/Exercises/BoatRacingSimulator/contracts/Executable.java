package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.*;

public interface Executable {
    String execute() throws DuplicateModelException,
            NonExistentModelException, RaceAlreadyExistsException,
            NoSetRaceException, InsufficientContestantsException;
}
