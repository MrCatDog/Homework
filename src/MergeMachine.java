public class MergeMachine<T extends Comparable<T>>{//? super T
    //играем с дженериками

    /*public T[] merge (T[] list1, T[] list2) {
        int index1=0, index2=0, resultIndex=0, cmp; //ну а кому нужны итераторы?!?
        int len = list1.length+list2.length;
        T[] result=(T[])new Object[len];//насколько допустимо? видимо не очень))))
        for(int i=0;i<len;i++) {
            cmp=list1[index1].compareTo(list2[index2]);
            if(cmp>=0) {
                result[resultIndex++]=list1[index1++];
            } else {
                result[resultIndex++]=list2[index2++];
            }
        }
        return result;
    }*/

    //проиграли

    public int[] merge (int[] list1, int[] list2) {
        int index1=0, index2=0, resultIndex=0;
        int len = list1.length+list2.length;
        int[] result=new int[len];

        while(index1<list1.length && index2<list2.length) {
            if(list1[index1]-list2[index2]<=0) {
                result[resultIndex++]=list1[index1++];
            } else {
                result[resultIndex++]=list2[index2++];
            }
        }

        //кто-то из этих циклов добавит остатки большего массива(если он есть)
        while(index1<list1.length) {
            result[resultIndex++] = list1[index1++];
        }

        while (index2<list2.length) {
            result[resultIndex++]=list2[index2++];
        }

        return result;
    }
}
