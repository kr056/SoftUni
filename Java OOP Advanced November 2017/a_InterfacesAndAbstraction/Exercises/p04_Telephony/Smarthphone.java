package a_InterfacesAndAbstraction.Exercises.p04_Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smarthphone implements Callable, Browseable {
    private List<String> numbers;
    private List<String> sites;

    public Smarthphone() {
        this.numbers = new ArrayList<>();
        this.sites = new ArrayList<>();
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addSite(String site) {
        this.sites.add(site);
    }

    private boolean siteIsValid(String site) {
        char[] arr = site.toCharArray();

        for (char ch : arr) {
            if (Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIsNumberValid(String number) {
        char[] arr = number.toCharArray();

        for (char ch : arr) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String browse() {
        StringBuilder browser = new StringBuilder();

        for (String site : this.sites) {
            if (this.siteIsValid(site)) {
                browser.append(String.format("Browsing: %s!%n", site));
            } else {
                browser.append(String.format("Invalid URL!%n"));
            }
        }

        return browser.toString();
    }

    @Override
    public String call() {
        StringBuilder caller = new StringBuilder();

        for (String number : this.numbers) {
            if (this.checkIsNumberValid(number)) {
                caller.append(String.format("Calling... %s%n", number));
            } else {
                caller.append(String.format("Invalid number!%n"));
            }
        }

        return caller.toString();
    }
}
