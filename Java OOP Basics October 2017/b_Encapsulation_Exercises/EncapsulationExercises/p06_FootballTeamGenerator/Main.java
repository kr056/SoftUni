package EncapsulationExercises.p06_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();
        List<String> addedPlayers = new ArrayList<>();

        while (true) {
            String line = bf.readLine();

            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("[;]");
            String cmd = tokens[0];

            if ("Team".equals(cmd)) {
                try {
                    String teamName = tokens[1];
                    Team team = new Team(teamName);
                    teams.put(teamName, team);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                switch (cmd) {
                    case "Add":
                        String team = tokens[1];

                        if (!teams.containsKey(team)) {
                            System.out.printf("Team %s does not exist.%n", team);
                        } else {
                            try {
                                Player player = new Player(tokens[2], Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]),
                                        Integer.valueOf(tokens[5]), Integer.valueOf(tokens[6]), Integer.valueOf(tokens[7]));

                                if (!addedPlayers.contains(tokens[2])) {
                                    teams.get(team).addPlayer(player);
                                    addedPlayers.add(tokens[2]);
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        break;
                    case "Remove":
                        String teamName = tokens[1];
                        String playerName = tokens[2];

                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            teams.get(teamName).removePlayer(playerName);
                        }

                        break;
                    case "Rating":
                        if (!teams.containsKey(tokens[1])) {
                            System.out.printf("Team %s does not exist.%n", tokens[1]);
                        } else {
                            System.out.printf("%s - %d%n", tokens[1], Math.round(teams.get(tokens[1]).getRating()));
                        }
                        break;
                }
            }
        }
    }
}
