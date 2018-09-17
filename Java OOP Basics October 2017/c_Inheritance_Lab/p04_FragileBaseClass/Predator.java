package c_Inheritance_Lab.p04_FragileBaseClass;

class Predator extends Animal {
    private int health;

    void feed(Food food) {
        super.foodEaten.add(food);
        this.health++;
    }

    int getHealth() {
        return health;
    }
}
