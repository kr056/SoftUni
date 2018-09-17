package DefiningClassesExercises.p09_Google;

class Child {
    private String childName;
    private String childBirthday;

    Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    String getChildInfo() {
        return this.childName + " " + this.childBirthday;
    }
}
