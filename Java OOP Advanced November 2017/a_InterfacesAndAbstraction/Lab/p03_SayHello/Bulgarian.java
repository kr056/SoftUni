package a_InterfacesAndAbstraction.Lab.p03_SayHello;

public class Bulgarian extends BasePerson implements Person {


    Bulgarian(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
