package b_Generics.Lab.p01_JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> jarOfElements;

    public Jar() {
        this.jarOfElements = new ArrayDeque<T>();
    }

    public void add(T element){
        this.jarOfElements.push(element);
    }

    public T remove(){
        return this.jarOfElements.pop();
    }
}
