package g_ISPandDIP.Lab.p01_SystemResources;

import java.time.LocalTime;

public class TestTime implements TimeProvider{
    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
