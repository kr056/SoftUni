package a_InterfacesAndAbstraction.Exercises.p10_mood3;

public class BaseGameObject implements GameObject {
    private String name;
    private String hashedPassword;
    private int level;

    public BaseGameObject(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public int getLevel() {
        return level;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
