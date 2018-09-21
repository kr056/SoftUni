package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.*;

public interface CommandHandler {
    String executeCommand(String[] parameters)
            throws DuplicateModelException,
            NonExistentModelException,
            RaceAlreadyExistsException,
            NoSetRaceException,
            InsufficientContestantsException;
}
