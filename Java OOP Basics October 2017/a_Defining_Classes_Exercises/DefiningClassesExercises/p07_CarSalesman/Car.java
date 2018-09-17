package DefiningClassesExercises.p07_CarSalesman;

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    private String weightToString(int weight) {
        String weightStr = Integer.toString(weight).replace("0", "n/a");
        return weightStr;
    }

    void printCarProps(String model, Engine engine, int weight, String color) {
        System.out.println(model + ":");
        System.out.println("  " + engine.getModel() + ":");
        System.out.println("    Power: " + engine.getPower());

        if (engine.getDisplacement() == 0) {
            System.out.println("    Displacement: " + engine.displacementToString(engine.getDisplacement()));
        } else {
            System.out.println("    Displacement: " + engine.getDisplacement());
        }

        System.out.println("    Efficiency: " + engine.getEfficiency());

        if (weight == 0) {
            System.out.println("  Weight: " + weightToString(weight));
        } else {
            System.out.println("  Weight: " + weight);
        }

        System.out.println("  Color: " + color);
    }

    String getModel() {
        return model;
    }

    Engine getEngine() {
        return engine;
    }

    int getWeight() {
        return weight;
    }

    String getColor() {
        return color;
    }
}
