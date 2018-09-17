package c_Inheritance_Lab.p06_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

class StackOfStrings {
    private List<String> data;

    StackOfStrings() {
        this.data = new ArrayList<>();
    }

    void push(String item) {
        this.data.add(item);
    }

    String pop() {
        if (!this.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        } else {
            return "";
        }
    }

    String peek() {
        return this.data.get(this.data.size() - 1);
    }

    boolean isEmpty() {
        return this.data.isEmpty();
    }
}
