package DefiningClassesExercises.p06_RawData;

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    String getModel() {
        return model;
    }

    Engine getEngine() {
        return engine;
    }

    Cargo getCargo() {
        return cargo;
    }


    boolean checkTiresPressure() {
        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
