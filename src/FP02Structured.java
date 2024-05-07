import java.util.ArrayList;
import java.util.List;

public class FP02Structured {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Good, List of String

        list.add(15);
        list.add(20);
        list.add(30);
        list.add(1);
        list.add(95);

        int sum=addListStruct(list);
        System.out.println(sum);

    }

    private static int addListStruct(List<Integer> list) {
        int sum=0;

        for(int x:list){
            sum+=x;
        }

        return  sum;
    }

    private static void printAllNumbersInListStructures(List<Integer> list) {

        for (int x:list){
            System.out.println(x);
        }

    }
    private static void printEvenNumbersInListStructures(List<Integer> list) {

        for (int x:list) {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        }

    }

    private static void printSquares(List<Integer> nos){
        for(int x:nos){
            System.out.println(x*x);
        }
    }

}
