package g_ISPandDIP.Lab.p01_SystemResources;

public class Main {
    public static void main(String[] args) {
        TimeProvider time = new TestTime();
        Writer writer = new ConsoleWriter();
        GreetingClock greetingClock = new GreetingClock(time, writer);
        greetingClock.greeting();
    }
}
