package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs;

public class Mission implements IMission {
    private String codeName;
    private String status;

    public Mission(String codeName, String status) {
        this.codeName = codeName;
        this.status = status;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void completeMission() {
        this.status = "Finished";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Code Name: %s State: %s%n",
                this.getCodeName(), this.getStatus()));

        return sb.toString();
    }
}
