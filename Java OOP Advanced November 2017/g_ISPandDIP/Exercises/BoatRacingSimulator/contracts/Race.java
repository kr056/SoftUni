package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

import g_ISPandDIP.Exercises.BoatRacingSimulator.exeptions.DuplicateModelException;

import java.util.List;

public interface Race
{
    int getDistance();

    int getWindSpeed ();

    int getOceanCurrentSpeed();

    boolean getAllowsMotorboats ();

    void addParticipant(Boat boat) throws DuplicateModelException, DuplicateModelException;

    List<Boat> getParticipants();
}
