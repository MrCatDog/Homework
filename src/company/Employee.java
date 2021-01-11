package company;

public class Employee {
    private String name;
    private int salary;
    private String post;
    private int age;

    public Employee(String name, int salary, String post, int age) {
        this.name = name;
        this.salary = salary;
        this.post = post;
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
