package h_ObjectCommunicationAndEvents.Exercises.p03_DependencyInversion;

public class PrimitiveCalculator {

    private Calculator calculator;

    public PrimitiveCalculator() {
        this.calculator = new AdditionStrategy();
    }

    public void changeStrategy(String operator) {
        switch (operator) {
            case "+":
                this.calculator = new AdditionStrategy();
                break;
            case "-":
                this.calculator = new SubtractionStrategy();
                break;
            case "*":
                this.calculator = new MultiplicationStrategy();
                break;
            case "/":
                this.calculator = new DivisionStrategy();
                break;
        }
    }

    public int executeStrategy(int num1, int num2) {
        return calculator.calculate(num1, num2);
    }

}
