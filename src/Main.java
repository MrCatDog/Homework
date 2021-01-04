import company.Department;
import company.Employee;
import socialNetwork.SocialNetwork;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DivisibilityHandler divisibilityHandler = new DivisibilityHandler();
        MergeMachine<Integer> mergeMachine = new MergeMachine<>();
        ThreeDigitNumbers threeDigitNumbers = new ThreeDigitNumbers();
        Words words = new Words();

        for(int i=0;i<=100;i++) {
            System.out.println(divisibilityHandler.FizzBuff(i));
        }
        System.out.println();

        for(int i=0;i<=100;i++) {
            System.out.println(divisibilityHandler.FizzBuffWoof(i));
        }
        System.out.println();

        System.out.println(divisibilityHandler.ThreeFiveSum(10));

        int[] first = {3,7,9,18};
        int[] second = {1,2,6,11,17,20};//как паковать/распаковать весь массив без цикла?
        System.out.println(Arrays.toString(mergeMachine.merge(first, second)));

        System.out.println("Max: "+threeDigitNumbers.biggestDigit());
        System.out.println("Sum: "+threeDigitNumbers.sumOfFirst());
        System.out.println("Sum of all: "+threeDigitNumbers.sumOfAll());

        System.out.println();
        String[] wordsAlphabet = {"pelmeni","cAT","Cocoa","MeaTBall","NorTh"};
        ArrayList<String> listOfWords = new ArrayList<>();
        for(int i=0;i<6;i++) {
            listOfWords.addAll(Arrays.asList(wordsAlphabet));
        }
        words.NWord(listOfWords,2);
        System.out.println();
        words.upperLowerCase(listOfWords);
        System.out.println();
        for (int i=0;i<3;i++)
            listOfWords.add("hello");
        for (int i=0;i<7;i++)
            listOfWords.add("world");
        words.uniqueWords(listOfWords);
        System.out.println();

        Department company = new Department("Директорат");
        company.addEmployee(new Employee("Путин Владимир Владимирович",1000000, "Директор", 64));
        company.addEmployee(new Employee("Агутин Леонид Николаевич",150, "Зам. Директор", 46));
        company.addEmployee(new Employee("Медведев Дмитрий Анатольевич",0, "Пйос смердячий", 34));
        Department depBuff = new Department("Юридический отдел");
        depBuff.addEmployee(new Employee("Хрущёв Никита Сергеевич",100, "Глава Юр.отдела", 65));
        depBuff.addEmployee(new Employee("Черненко Константин Устинович",50, "Юрист", 57));
        company.addSubordinate(depBuff);
        depBuff = new Department("Бухгалтерия");
        depBuff.addEmployee(new Employee("Ельцин Борис Николаевич",200, "Гл. Бухгалтер", 44));
        depBuff.addEmployee(new Employee("Маленков Георгий Максимилианович",100, "Бухгалтер", 33));
        company.addSubordinate(depBuff);
        depBuff = new Department("Производство");
        depBuff.addEmployee(new Employee("Ленин Владимир Ильич",250, "Нач. Производства", 36));
        Department depBuff2 = new Department("Цех 1");
        depBuff2.addEmployee(new Employee("Сталин Иосиф Вассарионович",70, "Нач. Цеха 1", 70));
        depBuff2.addEmployee(new Employee("Андропов Юрий Владимирович",30, "Мастер", 33));
        depBuff.addSubordinate(depBuff2);
        depBuff.addSubordinate(new Department("Цех 2")); //предположим, что тут нет сотрудников
        depBuff2 = new Department("Цех 3");
        depBuff2.addEmployee(new Employee("Брежнев Леонид Ильич",80, "Нач. Цеха 2", 70));
        depBuff2.addEmployee(new Employee("Горбачёв Михаил Сергеевич",20, "Мастер", 56));
        depBuff.addSubordinate(depBuff2);
        company.addSubordinate(depBuff);

        company.employeeOutput();
        System.out.println("Самые молодые:");
        for (Employee val:company.youngestEmployee()) {
            System.out.println(val.getName()+", "+val.getAge());
        }
        System.out.println("Самые старые:");
        for (Employee val:company.oldestEmployee()) {
            System.out.println(val.getName()+", "+val.getAge());
        }
        System.out.println("Общая ЗП:");
        System.out.println(company.overallSalary());

        SocialNetwork VK = new SocialNetwork();
        VK.addUser("1");
        VK.addUser("2");
        VK.addUser("3");
        VK.addUser("4");
        VK.addUser("5");
        VK.addUser("6");
        VK.addUser("7");
        VK.addUser("8");
        VK.addUser("9");
        VK.addUser("10");
        VK.addUser("11");
        VK.addUser("12");
        VK.addUser("13");
        VK.addUser("14");
        VK.newFriends("9","1");
        VK.newFriends("9","2");
        VK.newFriends("9","7");
        VK.newFriends("2","6");
        VK.newFriends("2","10");
        VK.newFriends("10","6");
        VK.newFriends("7","6");
        VK.newFriends("7","8");
        VK.newFriends("8","14");
        VK.newFriends("3","4");
        VK.newFriends("4","5");
        VK.newFriends("5","12");
        VK.newFriends("5","13");
        VK.newFriends("11","12");
        VK.newFriends("13","12");
        VK.newFriends("3","5");
        System.out.println("");
        System.out.println("Соцсеть:");
        VK.findFriends("8");
    }
}
