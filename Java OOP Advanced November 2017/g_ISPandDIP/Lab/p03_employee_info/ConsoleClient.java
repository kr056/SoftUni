package g_ISPandDIP.Lab.p03_employee_info;

import g_ISPandDIP.Lab.p03_employee_info.interfaces.Formatter;
import g_ISPandDIP.Lab.p03_employee_info.interfaces.InfoProvider;

public class ConsoleClient {

    private Formatter formatter;
    private InfoProvider infoProvider;

    public ConsoleClient(Formatter formatter, InfoProvider infoProvider) {
        this.formatter = formatter;
        this.infoProvider = infoProvider;
    }

    public void run(){
        String output = formatter.format(infoProvider.getEmployeesByName());
        System.out.println(output);    }
}
