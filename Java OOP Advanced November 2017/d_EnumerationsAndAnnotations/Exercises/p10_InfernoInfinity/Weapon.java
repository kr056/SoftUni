package d_EnumerationsAndAnnotations.Exercises.p10_InfernoInfinity;

@CustomClass(author = "Pesho", revision = 3
        , description = "Used for Java OOP Advanced course - Enumerations and Annotations."
        , reviewers = "Pesho, Svetlio")

public class Weapon implements Comparable<Weapon> {
    private String name;
    private int minDmg;
    private int maxDmg;
    private Gem[] gems;
    private int strength;
    private int agility;
    private int vitality;

    public Weapon(String name, WeaponKind weaponKind) {
        this.name = name;
        this.minDmg = weaponKind.getMinDmg();
        this.maxDmg = weaponKind.getMaxDmg();
        this.gems = new Gem[weaponKind.getSocketsCount()];
    }

    public void addGem(Gem gem, int index) {
        if (index >= 0 && index < this.gems.length) {
            if (this.gems[index] != null) {
                this.strength -= this.gems[index].getStrength();
                this.agility -= this.gems[index].getAgility();
                this.vitality -= this.gems[index].getVitality();
            }

            this.strength += gem.getStrength();
            this.agility += gem.getAgility();
            this.vitality += gem.getVitality();
            this.gems[index] = gem;
        }
    }

    public void removeGem(int index) {
        if (index >= 0 && index < this.gems.length && this.gems[index] != null) {
            this.strength -= this.gems[index].getStrength();
            this.agility -= this.gems[index].getAgility();
            this.vitality -= this.gems[index].getVitality();
            this.gems[index] = null;
        }
    }

    private double getItemLevel() {
        double itemLevel = 0;
        int minDmgForAdd = 0;
        int maxDmgForAdd = 0;

        minDmgForAdd += this.strength * 2;
        maxDmgForAdd += this.strength * 3;
        minDmgForAdd += this.agility;
        maxDmgForAdd += this.agility * 4;

        int totalMinDmg = minDmgForAdd + this.minDmg;
        int totalMaxDmg = maxDmgForAdd + this.maxDmg;

        itemLevel = (totalMinDmg + totalMaxDmg) / 2.0 + this.strength + this.agility
                + this.vitality;

        return itemLevel;
    }

    public void printCompare() {
        int minDmgForAdd = 0;
        int maxDmgForAdd = 0;

        minDmgForAdd += this.strength * 2;
        maxDmgForAdd += this.strength * 3;
        minDmgForAdd += this.agility;
        maxDmgForAdd += this.agility * 4;

        System.out.print(String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f) %n",
                this.name, this.minDmg + minDmgForAdd, this.maxDmg + maxDmgForAdd, this.strength, this.agility, this.vitality, this.getItemLevel()));

    }

    public void print() {
        int minDmgForAdd = 0;
        int maxDmgForAdd = 0;

        minDmgForAdd += this.strength * 2;
        maxDmgForAdd += this.strength * 3;
        minDmgForAdd += this.agility;
        maxDmgForAdd += this.agility * 4;

        System.out.print(String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality%n",
                this.name, this.minDmg + minDmgForAdd, this.maxDmg + maxDmgForAdd, this.strength, this.agility, this.vitality));

    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

//    @Override
//    public String toString() {
//        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality%n",
//                this.name, this.minDmg, this.maxDmg, this.strength, this.agility, this.vitality);
//    }
}
