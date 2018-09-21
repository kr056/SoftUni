package g_ISPandDIP.Lab.p03_employee_info;

import g_ISPandDIP.Lab.p03_employee_info.interfaces.Database;
import g_ISPandDIP.Lab.p03_employee_info.interfaces.Formatter;
import g_ISPandDIP.Lab.p03_employee_info.interfaces.InfoProvider;

public class Main {

    public static void main(String[] args) {
        Database database = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(database);
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(formatter, employeeInfo);
        consoleClient.run();
    }
}
