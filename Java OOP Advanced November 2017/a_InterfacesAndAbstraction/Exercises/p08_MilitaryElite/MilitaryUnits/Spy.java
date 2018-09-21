package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d%n", super.getFirstName(), super.getLastName(), super.getId()));
        sb.append(String.format("Code Number: %s%n", this.getCodeNumber()));

        return sb.toString();
    }
}
