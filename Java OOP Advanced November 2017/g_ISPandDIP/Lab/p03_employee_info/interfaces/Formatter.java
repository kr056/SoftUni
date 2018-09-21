package g_ISPandDIP.Lab.p03_employee_info.interfaces;

import g_ISPandDIP.Lab.p03_employee_info.Employee;

public interface Formatter {
    String format(Iterable<Employee> employees);
}
