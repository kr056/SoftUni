package a_InterfacesAndAbstraction.Lab.p03_SayHello;

public class Chinese extends BasePerson implements Person {

    Chinese(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
