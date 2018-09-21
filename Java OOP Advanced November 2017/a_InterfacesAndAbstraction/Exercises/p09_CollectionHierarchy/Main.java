package a_InterfacesAndAbstraction.Exercises.p09_CollectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        AddCollectionImpl<String> addCollection = new AddCollectionImpl<>();
        AddRemoveCollectionImpl<String> addRemoveCollection = new AddRemoveCollectionImpl<>();
        MyListImpl<String> myList = new MyListImpl<>();

        String[] tokens = bf.readLine().split("\\s+");
        int removeOperationsCount = Integer.valueOf(bf.readLine());

        StringBuilder addCollText = new StringBuilder();
        StringBuilder addRemoveCollText = new StringBuilder();
        StringBuilder myListText = new StringBuilder();

        for (String token : tokens) {
            addCollText.append(addCollection.add(token)).append(" ");
            addRemoveCollText.append(addRemoveCollection.add(token)).append(" ");
            myListText.append(myList.add(token)).append(" ");
        }

        System.out.println(addCollText);
        System.out.println(addRemoveCollText);
        System.out.println(myListText);

        addRemoveCollText.setLength(0);
        myListText.setLength(0);

        for (int i = 0; i < removeOperationsCount; i++) {
            addRemoveCollText.append(addRemoveCollection.remove()).append(" ");
            myListText.append(myList.remove()).append(" ");
        }

        System.out.println(addRemoveCollText);
        System.out.println(myListText);
    }
}
