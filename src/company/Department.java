package company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Department> subordinates;
    private ArrayList<Employee> staff;

    public Department(String name) {
        this.name = name;
        this.staff = new ArrayList<>();
        this.subordinates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Department> getSubordinates() {
        return this.subordinates;
    }

    public ArrayList<Employee> getStaff() {
        return this.staff;
    }

    public void addSubordinate(Department department) {
        subordinates.add(department);
    }

    public void addEmployee(Employee employee) {
        staff.add(employee);
    }

    public void outputNames() {
        if (staff.isEmpty()) {
            System.out.println("Нет сотрудников.");
        } else {
            for (Employee val : staff)
                System.out.println(val.getName());
        }
    }
}
