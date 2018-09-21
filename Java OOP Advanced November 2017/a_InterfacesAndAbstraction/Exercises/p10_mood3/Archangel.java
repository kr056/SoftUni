package a_InterfacesAndAbstraction.Exercises.p10_mood3;

public class Archangel extends BaseGameObject {

    private int mana;

    public Archangel(String name, int level, int mana) {
        super(name, level);
        this.mana = mana;
    }

    public void hashPassword() {
        char[] nameArr = super.getName().toCharArray();

        String reversedUsername = "";

        for (int i = nameArr.length - 1; i >= 0; i--) {
            reversedUsername += nameArr[i];
        }

        String result = reversedUsername + Integer.toString(reversedUsername.length() * 21);

        this.setHashedPassword(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("\"%s\" | \"%s\" -> Archangel%n"
                , super.getName(), super.getHashedPassword()));
        sb.append(String.format("%d%n", super.getLevel() * this.mana));

        return sb.toString();
    }
}
