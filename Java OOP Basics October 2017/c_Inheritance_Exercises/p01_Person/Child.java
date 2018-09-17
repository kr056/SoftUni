package c_Inheritance_Exercises.p01_Person;

class Child extends Person {

    Child(String name, int age) {
        super(name, age);
    }

    @Override
    void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
