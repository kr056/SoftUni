package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

class ExtendedArrayList<T extends Comparable> extends ArrayList<T> {
     T max() {
        T max = null;

        Iterator<T> iterator = super.iterator();

        while (iterator.hasNext()) {
            T nextElement = iterator.next();

            if (max == null || max.compareTo(nextElement) < 0) {
                max = nextElement;
            }
        }

        return max;
    }

     T min() {
        T min = null;

        Iterator<T> iterator = super.iterator();

        while (iterator.hasNext()) {
            T nextElement = iterator.next();

            if (min == null || min.compareTo(nextElement) > 0) {
                min = nextElement;
            }
        }

        return min;
    }

}
