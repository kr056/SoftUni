package Avatar;


import Avatar.Benders.AirBender;
import Avatar.Benders.EarthBender;
import Avatar.Benders.FireBender;
import Avatar.Benders.WaterBender;
import Avatar.Monuments.AirMonument;
import Avatar.Monuments.EarthMonument;
import Avatar.Monuments.FireMonument;
import Avatar.Monuments.WaterMonument;

public class Factory {

    public static void createBender(String type, String name, int power, double secP) {
        switch (type) {
            case "Air":
                Controller.getAirNation().addBender(new AirBender(name, power, secP));
                break;
            case "Water":
                Controller.getWaterNation().addBender(new WaterBender(name, power, secP));
                break;
            case "Fire":
                Controller.getFireNation().addBender(new FireBender(name, power, secP));
                break;
            case "Earth":
                Controller.getEarthNation().addBender(new EarthBender(name, power, secP));
                break;
            default:
                break;
        }
    }

    public static void createMonument(String type, String name, int affinity) {
        switch (type) {
            case "Air":
                Controller.getAirNation().addMonument(new AirMonument(name, affinity));
                break;
            case "Water":
                Controller.getWaterNation().addMonument(new WaterMonument(name, affinity));
                break;
            case "Fire":
                Controller.getFireNation().addMonument(new FireMonument(name, affinity));
                break;
            case "Earth":
                Controller.getEarthNation().addMonument(new EarthMonument(name, affinity));
                break;
            default:
                break;
        }
    }
}
