package c_Inheritance_Lab.p04_FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

public class Animal {
    ArrayList<Food> foodEaten;

    Animal() {
        this.foodEaten = new ArrayList<>();
    }

    private void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        for (Food f : food) {
            this.eat(f);
        }
    }

}
