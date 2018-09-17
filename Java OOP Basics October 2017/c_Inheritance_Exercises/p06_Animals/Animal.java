package c_Inheritance_Exercises.p06_Animals;

public class Animal {

    private static final String INVALID_INPUT_EXCEPTION = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION);
        }
        this.gender = gender;
    }


    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("\n");
        sb.append(String.format("%s %d %s%n", this.name, this.age, this.gender));
        sb.append(this.produceSound()).append("\n");

        return sb.toString();
    }

}
