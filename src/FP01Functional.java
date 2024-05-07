import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Good, List of String

        list.add(15);
        list.add(20);
        list.add(30);
        list.add(1);
        list.add(95);


        printAllNumbersInListFunctional(list);
        printEvenNumbersInListFunctional(list);
        System.out.println();
        printsquares(list);
    }

    private static void printAllNumbersInListFunctional(List<Integer> list) {
        /*
        * For Functional Programming convert the list of numbers into a stream of numbers
        *
        * Instead of getting elements like {15,20,30,1,95}, we will get numbers like
        * 15
        * 20
        * 30
        * 1
        * 95
        * */
//        list.stream().forEach(FP02Structured::print);
        list.stream().forEach(System.out::println);
//        for (int x:list){
//            System.out.println(x);
//        }

    }

    private static  boolean isEven(int num){
        return num%2==0;
    }

    private static void printEvenNumbersInListFunctional(List<Integer> list) {
        /*
        * For Functional Programming convert the list of numbers into a stream of numbers
        *
        * Instead of getting elements like {15,20,30,1,95}, we will get numbers like
        * 15
        * 20
        * 30
        * 1
        * 95
        * */
//        list.stream().forEach(FP02Structured::print);
        list.stream()
                .filter(FP01Functional::isEven) /*** Here We should use lambda Expression! **/
                .forEach(System.out::println);

        // So much of confusion isn't it !
        // Creating Different methods for executing functional programming

        // To simplify it we use lambda Function!
        // number -> number % 2
        list.stream().filter(number -> number%2==0).forEach(System.out::println);

        // Create another list after performing each operation on the elements of a given list
        List<Integer> doubleNum=doubleList(list);

        System.out.println(doubleNum);


    }

    private static List<Integer> doubleList(List<Integer> list) {
        // With the help of Collect method we collect all the elements from the list and create another list!
        return list.stream().map(num->num*num).collect(Collectors.toList());
    }

    private static void printsquares(List<Integer> nos){
        nos.stream().map(num->num*num).forEach(System.out::println);
    }

    private static  void printCubes(List<Integer> nos){
        nos.stream().map(no->no*no*no).forEach(System.out::println);
    }


    private  static void print(int number){
        System.out.println(number);
    }
}
