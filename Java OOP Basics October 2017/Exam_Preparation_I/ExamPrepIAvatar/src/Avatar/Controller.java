package Avatar;

import Avatar.Benders.Bender;
import Avatar.Monuments.Monument;

import java.util.ArrayList;

public class Controller {

    private static Nation airNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation fireNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation waterNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation earthNation = new Nation(new ArrayList<>(), new ArrayList<>());

    static Nation getAirNation() {
        return airNation;
    }

    static Nation getFireNation() {
        return fireNation;
    }

    static Nation getWaterNation() {
        return waterNation;
    }

    static Nation getEarthNation() {
        return earthNation;
    }

    static void beginWar() {
        double airNationPower = airNation.calculateNationPower();
        double waterNationPower = waterNation.calculateNationPower();
        double earthNationPower = earthNation.calculateNationPower();
        double fireNationPower = fireNation.calculateNationPower();

        if (airNationPower > fireNationPower && airNationPower > waterNationPower && airNationPower > earthNationPower) {
            clearNationBendersAndMonuments(fireNation, waterNation, earthNation);
        } else if (fireNationPower > airNationPower && fireNationPower > waterNationPower && fireNationPower > earthNationPower) {
            clearNationBendersAndMonuments(waterNation, earthNation, airNation);
        } else if (waterNationPower > airNationPower && waterNationPower > fireNationPower && waterNationPower > earthNationPower) {
            clearNationBendersAndMonuments(fireNation, airNation, earthNation);
        } else {
            clearNationBendersAndMonuments(waterNation, fireNation, airNation);
        }
    }

    private static void clearNationBendersAndMonuments(Nation n1, Nation n2, Nation n3) {
        n1.clearBenders();
        n1.clearMonuments();
        n2.clearBenders();
        n2.clearMonuments();
        n3.clearBenders();
        n3.clearMonuments();
    }

    static String getStatus(String type) {
        Nation currentNation = getNation(type);

        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" Nation").append("\n");

        if (currentNation.getBenders().size() > 0) {
            sb.append("Benders:").append("\n");

            for (Bender bender : currentNation.getBenders()) {
                sb.append(bender.toString()).append("\n");
            }
        } else {
            sb.append("Benders: None").append("\n");
        }

        if (currentNation.getMonuments().size() > 0) {
            sb.append("Monuments:").append("\n");

            for (Monument monument : currentNation.getMonuments()) {
                sb.append(monument.toString()).append("\n");
            }
        } else {
            sb.append("Monuments: None").append("\n");
        }

        return sb.toString();
    }

    private static Nation getNation(String type) {
        switch (type) {
            case "Air":
                return getAirNation();
            case "Water":
                return getWaterNation();
            case "Fire":
                return getFireNation();
            case "Earth":
                return getEarthNation();
            default:
                return null;
        }
    }
}
