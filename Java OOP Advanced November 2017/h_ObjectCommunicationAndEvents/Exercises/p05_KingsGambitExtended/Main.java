package h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended;

import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.controllers.GambitController;
import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.models.Footman;
import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.models.King;
import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        GambitController gambitController = new GambitController();

        String kingName = bf.readLine();

        King king = King.getInstance();
        king.setName(kingName);

        gambitController.addUnit(king);

        String[] royalGuards = bf.readLine().split("\\s+");

        for (String royalGuard : royalGuards) {
            gambitController.addUnit(new RoyalGuard(royalGuard));
        }

        String[] footmans = bf.readLine().split("\\s+");

        for (String footman : footmans) {
            gambitController.addUnit(new Footman(footman));
        }

        while (true) {
            String[] line = bf.readLine().split("\\s+");

            if ("End".equals(line[0])) {
                break;
            }

            switch (line[0]) {
                case "Attack":
                    gambitController.attackKing();
                    break;
                case "Kill":
                    gambitController.killUnit(line[1]);
                    break;
            }
        }
    }
}
