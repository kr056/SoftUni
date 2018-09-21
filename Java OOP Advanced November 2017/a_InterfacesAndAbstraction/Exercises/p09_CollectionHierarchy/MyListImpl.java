package a_InterfacesAndAbstraction.Exercises.p09_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl<T> implements MyList<T> {

    private List<T> elements = new ArrayList<>();

    public MyListImpl() {
        this.elements=new ArrayList<>();
    }

    @Override
    public int add(T element) {
        this.elements.add(0,element);
        return 0;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public T remove() {
        return this.elements.remove(0) ;
    }
}
