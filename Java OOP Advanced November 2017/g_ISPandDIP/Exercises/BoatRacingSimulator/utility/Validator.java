package g_ISPandDIP.Exercises.BoatRacingSimulator.utility;

public final class Validator {
    public Validator() {
    }

    public static void ValidatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void ValidateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectModelLengthMessage, minModelLength));
        }
    }
}
