package c_Inheritance_Lab.p05_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList extends ArrayList {
    private Random rnd = new Random();

    Object getRandomElement() {
        int index = rnd.nextInt(super.size() - 1);
        return super.remove(index);
    }

}
