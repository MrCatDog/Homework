public class DivisibilityHandler {
    private StringBuilder answer = new StringBuilder();
    private String word3 = "Fizz";
    private String word5 = "Buzz";
    private String word7 = "Woof";

    public String FizzBuff(int number) {
        answer.setLength(0);
        if(number%3==0) {
            answer.append(word3).append(' ');
        }
        if(number%5==0) {
            answer.append(word5).append(' ');
        }
        if(answer.length()==0) {
            return Integer.toString(number);
        } else {
            return answer.toString();
        }
    }

    public String FizzBuffWoof(int number) {
        FizzBuff(number);
        if(number%7==0) {
            answer.append(word7).append(' ');
        }
        if(answer.length()==0) {
            return Integer.toString(number);
        } else {
            return answer.toString();
        }
    }

    public int ThreeFiveSum(int maxNumber) {
        int sum=0;
        for(int number=0;number<maxNumber;number++) {
            if ((number % 3 == 0) ^ (number % 5 == 0)) {
                sum+=number;
            }
        }
        return sum;
    }
}
