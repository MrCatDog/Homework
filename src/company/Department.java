package company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Department {
    private static int lastId=0;
    private int id;
    private String name;
    private ArrayList<Department> subordinates;
    private ArrayList<Employee> staff;

    public Department(String name) {
        this.id = lastId++;
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

    public void namesOut() {
        if(staff.isEmpty()) {
            System.out.println("Нет сотрудников.");
        } else {
            for (Employee val : staff)
                System.out.println(val.getName());
        }
    }

    public void employeeOutput() {
        Department depBuff;
        ArrayDeque<Department> deque = new ArrayDeque<>();
        deque.addFirst(this);
        while(!deque.isEmpty()) {
            depBuff=deque.pop();
            deque.addAll(depBuff.getSubordinates());
            System.out.println(depBuff.getName());
            depBuff.namesOut();
        }
    }

    public ArrayDeque<Employee> youngestEmployee() {
        ArrayDeque<Employee> employees = new ArrayDeque<>();
        int min = Integer.MAX_VALUE, age;
        Department depBuff;
        ArrayDeque<Department> deque = new ArrayDeque<>();
        deque.addFirst(this);
        while(!deque.isEmpty()) {
            depBuff=deque.pop();
            deque.addAll(depBuff.getSubordinates());
            for (Employee val:depBuff.getStaff()) {
                age = val.getAge();
                if(age<min) {
                    min=age;
                    employees.clear();
                    employees.add(val);
                } else if(age==min) {
                    employees.add(val);
                }
            }
        }
        return employees;
    }

    public ArrayDeque<Employee> oldestEmployee() {
        ArrayDeque<Employee> employees = new ArrayDeque<>();
        int min = Integer.MIN_VALUE, age;
        Department depBuff;
        ArrayDeque<Department> deque = new ArrayDeque<>();
        deque.addFirst(this);
        while(!deque.isEmpty()) {
            depBuff=deque.pop();
            deque.addAll(depBuff.getSubordinates());
            for (Employee val:depBuff.getStaff()) {
                age = val.getAge();
                if(age>min) {
                    min=age;
                    employees.clear();
                    employees.add(val);
                } else if(age==min) {
                    employees.add(val);
                }
            }
        }
        return employees;
    }

    public float overallSalary() {
        ArrayDeque<Department> deque = new ArrayDeque<>();
        Department depBuff;
        deque.addFirst(this);
        float sum=0;

        while(!deque.isEmpty()) {
            depBuff=deque.pop();
            deque.addAll(depBuff.getSubordinates());
            for (Employee val:depBuff.getStaff()) {
                sum+=val.getSalary();
            }
        }
        return sum;
    }
}
