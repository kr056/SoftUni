package b_Generics.Exercises.p05_CustomList;

public class CommandInterpreter {
    private Box<String> stringBox;

    public CommandInterpreter(Box<String> stringBox) {
        this.stringBox = stringBox;
    }

    public void interpretCommand(String[] data) {
        switch (data[0]) {
            case "Add":
                this.stringBox.add(data[1]);
                break;
            case "Remove":
                this.stringBox.remove(Integer.valueOf(data[1]));
                break;
            case "Contains":
                System.out.println(this.stringBox.contains(data[1]));
                break;
            case "Swap":
                this.stringBox.swap(Integer.valueOf(data[1]), Integer.valueOf(data[2]));
                break;
            case "Greater":
                System.out.println(this.stringBox.countGreaterThan(data[1]));
                break;
            case "Max":
                System.out.println(this.stringBox.getMax());
                break;
            case "Min":
                System.out.println(this.stringBox.getMin());
                break;
            case "Print":
                for (String el : this.stringBox) {
                    System.out.println(el);
                }
                break;
            case "Sort":
                this.stringBox.sort();
                break;
            default:
                break;
        }
    }
}
