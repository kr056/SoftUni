package g_ISPandDIP.Lab.p05_security_system;

public class KeyCardCheck implements KeyCardUI {

    private KeyCardUI securityUI;

    public KeyCardCheck(KeyCardUI securityUI) {
        this.securityUI = securityUI;
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public String requestKeyCard() {
        return "slide your key card";
    }
}
