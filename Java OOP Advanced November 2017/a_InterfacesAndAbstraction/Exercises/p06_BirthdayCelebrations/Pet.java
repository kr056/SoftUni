package a_InterfacesAndAbstraction.Exercises.p06_BirthdayCelebrations;

public class Pet implements Dateable {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
