package NeedForSpeed.Races;

import NeedForSpeed.Cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String go() {
        StringBuilder result = new StringBuilder();

        List<Car> winners = super.getParticipants().stream()
                .sorted((a, b) -> {
                    int racer1PP = a.getEP();
                    int racer2PP = b.getEP();

                    if (racer1PP > racer2PP) {
                        return -1;
                    } else if (racer1PP == racer2PP) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .limit(3)
                .collect(Collectors.toList());

        int firstPrize = super.getPrizePool() / 2;
        int secondPrize = (super.getPrizePool() * 30) / 100;
        int thirdPrize = (super.getPrizePool() * 20) / 100;

        List<Integer> prizes = new ArrayList<>();
        prizes.add(firstPrize);
        prizes.add(secondPrize);
        prizes.add(thirdPrize);

        result.append(String.format("%s - %d%n", super.getRoute(), super.getLength()));

        int prizesCounter = 0;
        int racersCounter = 1;

        for (Car car : winners) {
            result.append(String.format("%d. %s %s %dPP - $%d%n", racersCounter++, car.getBrand(), car.getModel(), car.getEP()
                    , prizes.get(prizesCounter++)));
        }

        return result.toString();
    }
}
