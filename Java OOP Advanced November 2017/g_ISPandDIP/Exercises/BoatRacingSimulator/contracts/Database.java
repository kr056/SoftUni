package g_ISPandDIP.Exercises.BoatRacingSimulator.contracts;

public interface Database {
    CrudRepository<Boat> getBoats();

    CrudRepository<BoatEngine> getEngines();
}
