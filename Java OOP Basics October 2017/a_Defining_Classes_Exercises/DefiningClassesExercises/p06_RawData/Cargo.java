package DefiningClassesExercises.p06_RawData;

class Cargo {
    private int weight;
    private String type;

    Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    String getType() {
        return type;
    }
}
