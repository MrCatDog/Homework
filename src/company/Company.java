package company;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Company {
    private Department directorate;

    public Company(Department directorate) {
        this.directorate = directorate;
    }

    public void employeeOutput() {
        Department depBuff;
        ArrayDeque<Department> deque = new ArrayDeque<>();
        deque.addFirst(directorate);
        while (!deque.isEmpty()) {
            depBuff = deque.pop();
            deque.addAll(depBuff.getSubordinates());
            System.out.println(depBuff.getName());
            depBuff.outputNames();
        }
    }

    public ArrayList<Employee> getYoungestEmployee() {
        ArrayList<Employee> answer = new ArrayList<>();
        findYoungestEmployee(directorate, answer);
        return answer;
    }

    private void findYoungestEmployee(Department department, ArrayList<Employee> answer) {
        for (Department val : department.getSubordinates()) {
            findYoungestEmployee(val, answer);
        }
        int min = answer.isEmpty() ? Integer.MAX_VALUE : answer.get(0).getAge();
        int age;
        for (Employee val : department.getStaff()) {
            age = val.getAge();
            if (age <= min) {
                if (age < min) {
                    answer.clear();
                    min = age;
                }
                answer.add(val);
            }
        }
    }

    public ArrayList<Employee> getOldestEmployee() {
        ArrayList<Employee> answer = new ArrayList<>();
        findOldestEmployee(directorate, answer);
        return answer;
    }

    private void findOldestEmployee(Department department, ArrayList<Employee> answer) {
        for (Department val : department.getSubordinates()) {
            findOldestEmployee(val, answer);
        }
        int max = answer.isEmpty() ? Integer.MIN_VALUE : answer.get(0).getAge();
        int age;
        for (Employee val : department.getStaff()) {
            age = val.getAge();
            if (age >= max) {
                if (age > max) {
                    answer.clear();
                    max = age;
                }
                answer.add(val);
            }
        }
    }

    public int getOverallSalary() {
        return overallSalary(directorate);
    }

    private int overallSalary(Department department) {
        int sum = 0;
        for (Department val : department.getSubordinates()) {
            sum += overallSalary(val);
        }
        for (Employee val : department.getStaff()) {
            sum += val.getSalary();
        }
        return sum;
    }
}
