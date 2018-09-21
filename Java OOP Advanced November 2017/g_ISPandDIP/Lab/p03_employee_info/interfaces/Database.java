package g_ISPandDIP.Lab.p03_employee_info.interfaces;

import g_ISPandDIP.Lab.p03_employee_info.Employee;

import java.util.List;

public interface Database {
    List<Employee> readEmployees();
}
