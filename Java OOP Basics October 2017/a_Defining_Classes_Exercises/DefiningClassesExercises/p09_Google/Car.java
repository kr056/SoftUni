package DefiningClassesExercises.p09_Google;

class Car {
    private String carModel;
    private int carSpeed;

    Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    String getCarInfo() {
        return this.carModel + " " + this.carSpeed;
    }
}
