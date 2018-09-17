package DefiningClassesExercises.p07_CarSalesman;

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    String displacementToString(int displacement) {
        String displacementStr = Integer.toString(displacement).replace("0", "n/a");
        return displacementStr;
    }

    String getModel() {
        return model;
    }

    int getPower() {
        return power;
    }

    int getDisplacement() {
        return displacement;
    }

    String getEfficiency() {
        return efficiency;
    }
}
