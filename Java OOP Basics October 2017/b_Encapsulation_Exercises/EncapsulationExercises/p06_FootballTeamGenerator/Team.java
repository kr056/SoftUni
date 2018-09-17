package EncapsulationExercises.p06_FootballTeamGenerator;

import java.util.HashSet;

class Team {
    private String name;
    private HashSet<Player> players;

    Team(String name) {
        this.setName(name);
        this.players = new HashSet<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    void addPlayer(Player player) {
        this.players.add(player);
    }

    void removePlayer(String playerName) {
        Player player = null;

        for (Player pl : this.players) {
            if (pl.getName().equals(playerName)) {
                player = pl;
            }
        }

        if (player == null) {
            System.out.printf("Player %s is not in %s team.%n", playerName, this.name);
        } else {
            this.players.remove(player);
        }
    }

    double getRating() {
        return this.players.size() > 0 ? this.players.stream().mapToDouble(Player::getPlayerAverageRating).average().getAsDouble() : 0;
    }

}
