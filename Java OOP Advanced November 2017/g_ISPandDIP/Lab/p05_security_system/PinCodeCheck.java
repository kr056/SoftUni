package g_ISPandDIP.Lab.p05_security_system;

public class PinCodeCheck implements PinCodeUI {

    private PinCodeUI securityUI;

    public PinCodeCheck(PinCodeUI securityUI) {
        this.securityUI = securityUI;
    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public int requestPinCode() {
        return 0;
    }
}
