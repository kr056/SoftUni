package c_IteratorsAndComparators.Exercises.p06_StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (Integer.compare(p1.getName().length(), p2.getName().length()) == 0) {
            return Character.compare(p1.getName().toUpperCase().charAt(0),
                    p2.getName().toUpperCase().charAt(0));
        }

        return Integer.compare(p1.getName().length(), p2.getName().length());
    }
}
