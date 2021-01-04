package company;

public class Employee {
    private static int lastId=0;
    private int id;
    private String name;
    private float salary;//ха-ах, класс, храню деньги во float
    private String post;
    private int age;

    public Employee(String name, float salary, String post, int age) {
        this.id = lastId++;
        this.name = name;
        this.salary = salary;
        this.post = post;
        this.age=age;
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
