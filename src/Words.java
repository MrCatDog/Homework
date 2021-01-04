import java.util.ArrayList;

public class Words {
    public void NWord(ArrayList<String> list, int step) {
        int num = step-1;
        while(num<list.size()) {
            System.out.println(list.get(num));
            num+=step;
        }
    }

    public void upperLowerCase(ArrayList<String> list) {
        StringBuilder answer = new StringBuilder();
        String firstLetter, endOfWord;
        for (String i:list) {
            firstLetter = i.substring(0,1);
            endOfWord = i.substring(1);
            firstLetter = firstLetter.toUpperCase();
            endOfWord = endOfWord.toLowerCase();
            answer.append(firstLetter).append(endOfWord);
        }
        System.out.println(answer.toString());
    }

    public void uniqueWords(ArrayList<String> list) {
        ArrayList<String> unique = new ArrayList<>();
        ArrayList<Integer> counters = new ArrayList<>();
        String bufS;
        int index, buf;
        for (String val:list) {
            if(!unique.contains(val)) {
                unique.add(val);
                counters.add(1);
            } else {
                index = unique.indexOf(val);
                counters.set(index, counters.get(index) + 1);
            }
        }

        for(int i = 0;i<counters.size();i++) {
            for(int j=0;j<counters.size()-1-i;j++) {
                if(counters.get(j)>counters.get(j+1)) {
                   buf=counters.get(j);
                   counters.set(j,counters.get(j+1));
                   counters.set(j+1,buf);

                   bufS = unique.get(j);
                   unique.set(j,unique.get(j+1));
                   unique.set(j+1,bufS);
                }
            }
        }

        for (int i=0;i<unique.size();i++) {
            System.out.println(unique.get(i)+" "+counters.get(i));
        }

    }
}
