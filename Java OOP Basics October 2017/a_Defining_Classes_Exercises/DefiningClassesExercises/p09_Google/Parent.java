package DefiningClassesExercises.p09_Google;

class Parent {
    private String parentName;
    private String parentBirthday;

    Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    String getParentInfo() {
        return this.parentName + " " + this.parentBirthday;
    }
}
