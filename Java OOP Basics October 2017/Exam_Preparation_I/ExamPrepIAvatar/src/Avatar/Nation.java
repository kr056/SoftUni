package Avatar;

import Avatar.Benders.Bender;
import Avatar.Monuments.Monument;

import java.util.Collections;
import java.util.List;

public class Nation {
    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(List<Bender> benders, List<Monument> monuments) {
        this.benders = benders;
        this.monuments = monuments;
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    public List<Bender> getBenders() {
        return Collections.unmodifiableList(this.benders);
    }

    public List<Monument> getMonuments() {
        return Collections.unmodifiableList(this.monuments);
    }

    public double calculateNationPower() {
        Double totalNationPower = 0.0;

        for (Bender bender : this.benders) {
            totalNationPower += bender.getBenderPower();
        }

        long monSum = 0;

        for (Monument monument : this.monuments) {
            monSum += monument.getMonPower();
        }

        totalNationPower += (totalNationPower / 100) * monSum;

        return totalNationPower;
    }

    public void clearBenders() {
        this.benders.clear();
    }

    public void clearMonuments() {
        this.monuments.clear();
    }
}
