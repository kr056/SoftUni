package PolymorphismLab.p02_OverrideMethod;


public class Square extends Rectangle {

    Square(double sideA, double sideB) {
        super(sideA, sideB);
    }

    @Override
    public double area(){
        return super.getSideA()*super.getSideA();
    }
}
