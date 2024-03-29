package NeedForSpeed.Races;

import NeedForSpeed.Cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    public String go() {
        StringBuilder result = new StringBuilder();
        List<Car> racers = super.getParticipants();

        for (Car car : racers) {
            car.decreaseDurability(this.laps * super.getLength() * super.getLength());
        }

        List<Car> winners = racers.stream()
                .sorted((a, b) -> {
                    int racer1PP = a.getOP();
                    int racer2PP = b.getOP();

                    if (racer1PP > racer2PP) {
                        return -1;
                    } else if (racer1PP == racer2PP) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .limit(4)
                .collect(Collectors.toList());

        int firstPrize = (super.getPrizePool() * 40) / 100;
        int secondPrize = (super.getPrizePool() * 30) / 100;
        int thirdPrize = (super.getPrizePool() * 20) / 100;
        int fourthPrize = (super.getPrizePool() * 10) / 100;

        List<Integer> prizes = new ArrayList<>();
        prizes.add(firstPrize);
        prizes.add(secondPrize);
        prizes.add(thirdPrize);
        prizes.add(fourthPrize);

        result.append(String.format("%s - %d%n", super.getRoute(), super.getLength() * this.laps));

        int prizesCounter = 0;
        int racersCounter = 1;

        for (Car car : winners) {
            result.append(String.format("%d. %s %s %dPP - $%d%n", racersCounter++, car.getBrand(), car.getModel(), car.getOP()
                    , prizes.get(prizesCounter++)));
        }

        return result.toString();
    }
}
