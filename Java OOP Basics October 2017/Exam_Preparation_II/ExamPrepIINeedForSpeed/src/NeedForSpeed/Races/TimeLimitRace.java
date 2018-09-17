package NeedForSpeed.Races;

import NeedForSpeed.Cars.Car;

import java.util.List;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    public String go() {
        StringBuilder result = new StringBuilder();
        List<Car> racer = super.getParticipants();

        int racerTime = super.getLength() * racer.get(0).getTP();
        int racerPrize = 0;
        String timeType = "";

        if (racerTime <= this.goldTime) {
            racerPrize = super.getPrizePool();
            timeType = "Gold Time";
        } else if (racerTime <= this.goldTime + 15) {
            racerPrize = super.getPrizePool() / 2;
            timeType = "Silver Time";
        } else {
            racerPrize = (super.getPrizePool() * 30) / 100;
            timeType = "Bronze Time";
        }

        result.append(String.format("%s - %d%n", super.getRoute(), super.getLength()));
        result.append(String.format("%s %s - %d s.%n", racer.get(0).getBrand(), racer.get(0).getModel(), racerTime));
        result.append(String.format("%s, $%d.%n", timeType, racerPrize));

        return result.toString();
    }
}
