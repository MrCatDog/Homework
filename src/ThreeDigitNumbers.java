public class ThreeDigitNumbers {
    public int biggestDigit() {
        StringBuilder number = new StringBuilder();
        int nextDigit;
        int max = (int) (Math.random()*8+1);
        number.append(max);
        for(int i=0;i<2;i++) {
            nextDigit = (int) (Math.random()*9);
            if(max<nextDigit) {
                max=nextDigit;
            }
            number.append(nextDigit);
        }
        System.out.println(number.toString());
        return max;
    }

    public int sumOfFirst() {
        int nextDigit,sum = 0;
        StringBuilder number = new StringBuilder();
        for(int i=0;i<3;i++) {
            nextDigit=(int) (Math.random()*8+1);
            sum+=nextDigit;
            number.append(nextDigit);
            for(int j=0;j<2;j++) {
                number.append((int) (Math.random()*9));
            }
            System.out.println(number.toString());
            number.setLength(0);
        }
        return sum;
    }

    public int sumOfAll() {
        StringBuilder number = new StringBuilder();
        int nextDigit = (int) (Math.random()*8+1);
        int sum = nextDigit;
        number.append(nextDigit);
        for(int i=0;i<2;i++) {
            nextDigit=(int) (Math.random()*9);
            sum+=nextDigit;
            number.append(nextDigit);
        }
        System.out.println(number.toString());
        return sum;
    }

}
