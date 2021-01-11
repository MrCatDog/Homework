import company.Company;
import company.Department;
import company.Employee;
import socialNetwork.SocialNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        fizzBuff();
        System.out.println();

        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuffWoof(i));
        }
        System.out.println();

        System.out.println(getThreeOrFiveSum(10));

        int[] first = {3, 7, 9, 18};
        int[] second = {1, 2, 6, 11, 17, 20};
        System.out.println(Arrays.toString(merge(first, second)));

        getBiggestDigit();
        getSumOfFirstDigits();
        getSumOfDigits();

        System.out.println();
        String[] wordsAlphabet = {"pelmeni", "cAT", "Cocoa", "", "MeaTBall", "NorTh"};
        ArrayList<String> listOfWords = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            listOfWords.addAll(Arrays.asList(wordsAlphabet));
        }
        getNWord(listOfWords, 5);
        System.out.println();
        setFirstToUpperCase(listOfWords);
        System.out.println();
        for (int i = 0; i < 3; i++)
            listOfWords.add("hello");
        for (int i = 0; i < 7; i++)
            listOfWords.add("world");
        countUniqueWords(listOfWords);
        System.out.println();

        Department directorate = new Department("Директорат");
        directorate.addEmployee(new Employee("Путин Владимир Владимирович", 1000000, "Директор", 64));
        directorate.addEmployee(new Employee("Агутин Леонид Николаевич", 150, "Зам. Директор", 46));
        directorate.addEmployee(new Employee("Медведев Дмитрий Анатольевич", 0, "Пйос смердячий", 34));
        Department depBuff = new Department("Юридический отдел");
        depBuff.addEmployee(new Employee("Хрущёв Никита Сергеевич", 100, "Глава Юр.отдела", 65));
        depBuff.addEmployee(new Employee("Черненко Константин Устинович", 50, "Юрист", 57));
        directorate.addSubordinate(depBuff);
        depBuff = new Department("Бухгалтерия");
        depBuff.addEmployee(new Employee("Ельцин Борис Николаевич", 200, "Гл. Бухгалтер", 44));
        depBuff.addEmployee(new Employee("Маленков Георгий Максимилианович", 100, "Бухгалтер", 33));
        directorate.addSubordinate(depBuff);
        depBuff = new Department("Производство");
        depBuff.addEmployee(new Employee("Ленин Владимир Ильич", 250, "Нач. Производства", 36));
        Department depBuff2 = new Department("Цех 1");
        depBuff2.addEmployee(new Employee("Сталин Иосиф Вассарионович", 70, "Нач. Цеха 1", 70));
        depBuff2.addEmployee(new Employee("Андропов Юрий Владимирович", 30, "Мастер", 33));
        depBuff.addSubordinate(depBuff2);
        depBuff.addSubordinate(new Department("Цех 2")); //предположим, что тут нет сотрудников
        depBuff2 = new Department("Цех 3");
        depBuff2.addEmployee(new Employee("Брежнев Леонид Ильич", 80, "Нач. Цеха 2", 70));
        depBuff2.addEmployee(new Employee("Горбачёв Михаил Сергеевич", 20, "Мастер", 56));
        depBuff.addSubordinate(depBuff2);
        directorate.addSubordinate(depBuff);
        Company company = new Company(directorate);

        company.employeeOutput();
        System.out.println("Самые молодые:");
        for (Employee val : company.getYoungestEmployee()) {
            System.out.println(val.getName() + ", " + val.getAge());
        }
        System.out.println("Самые старые:");
        for (Employee val : company.getOldestEmployee()) {
            System.out.println(val.getName() + ", " + val.getAge());
        }
        System.out.println("Общая ЗП:");
        System.out.println(company.getOverallSalary() + " рублесов");

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
        VK.makeFriends("9", "1");
        VK.makeFriends("9", "2");
        VK.makeFriends("9", "7");
        VK.makeFriends("2", "6");
        VK.makeFriends("2", "10");
        VK.makeFriends("10", "6");
        VK.makeFriends("7", "6");
        VK.makeFriends("7", "8");
        VK.makeFriends("8", "14");
        VK.makeFriends("3", "4");
        VK.makeFriends("4", "5");
        VK.makeFriends("5", "12");
        VK.makeFriends("5", "13");
        VK.makeFriends("11", "12");
        VK.makeFriends("13", "12");
        VK.makeFriends("3", "5");
        System.out.println("");
        System.out.println("Соцсеть:");
        VK.findFriends("8");

        AutoArray<String> autoArray = new AutoArray<>();
        autoArray.add("Love");
        autoArray.add("Love");
        autoArray.add("Pain");
        autoArray.add("i don't care");
        System.out.println("AutoArray:");
        System.out.println("size: " + autoArray.getSize());
        for(int i = 0; i<autoArray.getSize(); i++) {
            System.out.println(autoArray.get(i));
        }
    }

    public static void fizzBuff() {
        for (int number = 1; number <= 100; number++) {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Fizz Buff");
            } else if (number % 3 == 0) {
                System.out.println("Fizz");
            } else if (number % 5 == 0) {
                System.out.println("Buff");
            } else {
                System.out.println(number);
            }
        }
    }

    public static String fizzBuffWoof(int number) {
        ArrayList<String> answer = new ArrayList<>();
        if (number % 3 == 0) {
            answer.add("Fizz");
        }
        if (number % 5 == 0) {
            answer.add("Buff");
        }
        if (number % 7 == 0) {
            answer.add("Woof");
        }
        if (answer.isEmpty()) {
            return Integer.toString(number);
        } else {
            return String.join(" ", answer);
        }
    }

    public static int getThreeOrFiveSum(int maxNumber) {
        int sum = 0;
        for (int number = 0; number < maxNumber; number++) {
            if ((number % 3 == 0) || (number % 5 == 0)) {
                sum += number;
            }
        }
        return sum;
    }

    public static int[] merge(int[] list1, int[] list2) {
        int index1 = 0, index2 = 0, resultIndex = 0;
        int len = list1.length + list2.length;
        int[] result = new int[len];

        while (index1 < list1.length && index2 < list2.length) {
            if (list1[index1] <= list2[index2]) {
                result[resultIndex++] = list1[index1++];
            } else {
                result[resultIndex++] = list2[index2++];
            }
        }

        while (index1 < list1.length) {
            result[resultIndex++] = list1[index1++];
        }

        while (index2 < list2.length) {
            result[resultIndex++] = list2[index2++];
        }

        return result;
    }

    public static void getBiggestDigit() {
        Random random = new Random();
        int first = random.nextInt(9) + 1;
        int second = random.nextInt(10);
        int third = random.nextInt(10);

        System.out.println(Integer.toString(first) + second + third);
        if (first >= second && first >= third) {
            System.out.println("Max: " + first);
        } else if (second >= third) {
            System.out.println("Max: " + second);
        } else {
            System.out.println("Max: " + third);
        }
    }

    public static void getSumOfFirstDigits() {
        Random random = new Random();
        int first = random.nextInt(900) + 100;
        int second = random.nextInt(900) + 100;
        int third = random.nextInt(900) + 100;
        int sum = first / 100 + second / 100 + third / 100;
        System.out.println("Числа:");
        System.out.println(first + " " + second + " " + third);
        System.out.println("Сумма первых цифр: " + sum);
    }

    public static void getSumOfDigits() {
        Random random = new Random();
        int number = random.nextInt(900) + 100;
        int sum = number / 100 + (number / 10) % 10 + number % 10;
        System.out.println("Число:" + number + ", сумма цифр:" + sum);
    }

    public static void getNWord(ArrayList<String> list, int step) {
        int num = step - 1;
        while (num < list.size()) {
            System.out.println(list.get(num));
            num += step;
        }
    }

    public static void setFirstToUpperCase(ArrayList<String> list) {
        StringBuilder answer = new StringBuilder();
        String firstLetter, endOfWord;
        for (String i : list) {
            if (i.isEmpty()) {
                continue;
            }
            firstLetter = i.substring(0, 1);
            endOfWord = i.substring(1);
            firstLetter = firstLetter.toUpperCase();
            endOfWord = endOfWord.toLowerCase();
            answer.append(firstLetter).append(endOfWord);
        }
        System.out.println(answer.toString());
    }

    public static void countUniqueWords(ArrayList<String> list) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String val : list) {
            if (words.containsKey(val)) {
                words.replace(val, words.get(val) + 1);
            } else {
                words.put(val, 1);
            }
        }


        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        int buf;
        String bufStr;

        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size() - 1 - i; j++) {
                if (values.get(j) > values.get(j + 1)) {
                    buf = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set(j + 1, buf);

                    bufStr = keys.get(j);
                    keys.set(j, keys.get(j + 1));
                    keys.set(j + 1, bufStr);
                }
            }
        }

        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + values.get(i));
        }

    }
}
