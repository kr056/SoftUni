package ExamPreparationII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class p04_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Match> football = new ArrayList<>();

        while (true) {
            String input = bf.readLine();

            if ("Season End".equals(input)) {
                break;
            }

            String[] tokens = input.split("[\\-:\\s]+");

            String firstTeam = tokens[0];
            String secondTeam = tokens[1];
            String firstTeamGoals = tokens[3];
            String secondTeamGoals = tokens[4];

            Match homeTeam = new Match(firstTeam, secondTeam, firstTeamGoals, secondTeamGoals);
            Match awayTeam = new Match(secondTeam, firstTeam, secondTeamGoals, firstTeamGoals);
            football.add(homeTeam);
            football.add(awayTeam);

        }

        String[] teams = bf.readLine().split(", ");

        for (String team : teams) {
            List<Match> currentTeamMatches = football.stream()
                    .filter(x -> x.getFirstTeam().equals(team))
                    .sorted((a, b) -> a.getSecondTeam().compareTo(b.getSecondTeam()))
                    .collect(Collectors.toList());

            for (Match data : currentTeamMatches) {
                System.out.printf("%s - %s -> %s:%s\n", data.getFirstTeam(), data.getSecondTeam(), data.getFirstTeamGoals(), data.getSecondTeamGoals());
            }
        }

    }

    public static class Match {
        String firstTeam;

        String secondTeam;

        String firstTeamGoals;

        String secondTeamGoals;

        public Match() {
        }

        Match(String firstTeam, String secondTeam, String firstTeamGoals, String secondTeamGoals) {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
            this.firstTeamGoals = firstTeamGoals;
            this.secondTeamGoals = secondTeamGoals;
        }

        String getFirstTeam() {
            return firstTeam;
        }

        public void setFirstTeam(String firstTeam) {
            this.firstTeam = firstTeam;
        }

        String getSecondTeam() {
            return secondTeam;
        }

        public void setSecondTeam(String secondTeam) {
            this.secondTeam = secondTeam;
        }

        String getFirstTeamGoals() {
            return firstTeamGoals;
        }

        public void setFirstTeamGoals(String firstTeamGoals) {
            this.firstTeamGoals = firstTeamGoals;
        }

        String getSecondTeamGoals() {
            return secondTeamGoals;
        }

        public void setSecondTeamGoals(String secondTeamGoals) {
            this.secondTeamGoals = secondTeamGoals;
        }
    }
}