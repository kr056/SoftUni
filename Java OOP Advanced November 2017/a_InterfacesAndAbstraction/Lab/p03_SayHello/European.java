package a_InterfacesAndAbstraction.Lab.p03_SayHello;

public class European extends BasePerson implements Person {

    European(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
