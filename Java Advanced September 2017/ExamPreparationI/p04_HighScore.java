package ExamPreparationI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04_HighScore {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, List<OpponentInfo>> gameData = new LinkedHashMap<>();

        while (true) {
            String line = bf.readLine();

            if ("osu!".equals(line)) {
                break;
            }

            String[] tokens = line.split("[\\s<\\->]+");

            long playerOneScore = Long.parseLong(tokens[0]);
            String playerOneName = tokens[1];

            String playerTwoName = tokens[2];
            long playerTwoScore = Long.parseLong(tokens[3]);

            OpponentInfo opponentInfo = new OpponentInfo(playerTwoName, playerOneScore - playerTwoScore);

            if (!gameData.containsKey(playerOneName)) {
                gameData.put(playerOneName, new ArrayList<>());
            }

            gameData.get(playerOneName).add(opponentInfo);

            OpponentInfo opponentInfo2 = new OpponentInfo(playerOneName, playerTwoScore - playerOneScore);

            if (!gameData.containsKey(playerTwoName)) {
                gameData.put(playerTwoName, new ArrayList<>());
            }

            gameData.get(playerTwoName).add(opponentInfo2);
        }

        gameData.entrySet().stream()
                .sorted((a, b) -> sortByTotalScore(a, b))
                .forEach(p -> printAll(p));

    }

    private static void printAll(Map.Entry<String, List<OpponentInfo>> p) {
        System.out.printf("%s - (%d)\n", p.getKey(), p.getValue().stream().mapToLong(OpponentInfo::getMatchScore).sum());

        for (OpponentInfo op : p.getValue()) {
            System.out.printf("*   %s <-> %d\n", op.getOpponentName(), op.getMatchScore());
        }
    }

    private static int sortByTotalScore(Map.Entry<String, List<OpponentInfo>> a, Map.Entry<String, List<OpponentInfo>> b) {
        long playerOneScore = a.getValue().stream().mapToLong(OpponentInfo::getMatchScore).sum();
        long playerTwoScore = b.getValue().stream().mapToLong(OpponentInfo::getMatchScore).sum();

        if (playerTwoScore > playerOneScore) {
            return 1;
        } else if (playerOneScore == playerTwoScore) {
            return 0;
        } else {
            return -1;
        }
    }

    public static class OpponentInfo {
        String opponentName;
        long matchScore;

        public OpponentInfo() {
        }

        OpponentInfo(String opponentName, long matchScore) {
            this.opponentName = opponentName;
            this.matchScore = matchScore;
        }

        String getOpponentName() {
            return opponentName;
        }

        public void setOpponentName(String opponentName) {
            this.opponentName = opponentName;
        }

        long getMatchScore() {
            return matchScore;
        }

        public void setMatchScore(long matchScore) {
            this.matchScore = matchScore;
        }
    }
}
