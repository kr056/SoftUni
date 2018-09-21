package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite;


import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits.*;
import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Mission;
import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, ISoldier> units = new LinkedHashMap<>();

        while (true) {
            String line = bf.readLine();

            if ("End".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Private":
                    ISoldier p = new Private(Integer.valueOf(tokens[1]), tokens[2], tokens[3],
                            Double.valueOf(tokens[4]));
                    units.put(Integer.valueOf(tokens[1]), p);
                    break;
                case "LeutenantGeneral":
                    ILeutenantGeneral general = new LeutenantGeneral(Integer.valueOf(tokens[1]), tokens[2], tokens[3],
                            Double.valueOf(tokens[4]));

                    for (int i = 5; i < tokens.length; i++) {
                        general.add((Private) units.get(Integer.valueOf(tokens[i])));
                    }

                    units.put(Integer.valueOf(tokens[1]), general);
                    break;
                case "Commando":
                    try {
                        if ("Marines".equals(tokens[5]) || "Airforces".equals(tokens[5])) {
                            ICommando commando = new Commando(Integer.valueOf(tokens[1]), tokens[2], tokens[3],
                                    Double.valueOf(tokens[4]), tokens[5]);

                            for (int i = 6; i < tokens.length; i += 2) {
                                try {
                                    if ("inProgress".equals(tokens[i + 1]) || "Finished".equals(tokens[i + 1])) {
                                        Mission mission = new Mission(tokens[i], tokens[i +1]);
                                        commando.addMission(mission);
                                    }
                                } catch (Exception e) {}
                            }

                            units.put(Integer.valueOf(tokens[1]), commando);
                        }
                    } catch (Exception e) {}
                    break;
                case "Engineer":
                    try {
                        if ("Marines".equals(tokens[5]) || "Airforces".equals(tokens[5])) {
                            IEngineer engineer = new Engineer(Integer.valueOf(tokens[1]), tokens[2], tokens[3],
                                    Double.valueOf(tokens[4]), tokens[5]);

                            for (int i = 6; i < tokens.length; i+=2) {
                                try {
                                    Repair repair = new Repair(tokens[i], Integer.valueOf(tokens[i + 1]));
                                    engineer.addRepair(repair);
                                } catch (Exception e) {}
                            }

                            units.put(Integer.valueOf(tokens[1]), engineer);
                        }
                    } catch (Exception e) {}
                    break;
                case "Spy":
                    ISpy spy = new Spy(Integer.valueOf(tokens[1]), tokens[2], tokens[3],
                            tokens[4]);

                    units.put(Integer.valueOf(tokens[1]), spy);
                    break;
                default:
                    break;
            }
        }

        for (int key : units.keySet()) {
            System.out.print(units.get(key).toString());
        }
    }
}
