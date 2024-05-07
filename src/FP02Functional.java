import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FP02Functional {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Good, List of String

        list.add(15);
        list.add(20);
        list.add(30);
        list.add(1);
        list.add(95);

        int sum=addListStruct(list);
        System.out.println(sum);

        List<String> course=new ArrayList<String>();
        course.add("Spring");
        course.add("Spring Boot");
        course.add("AWS");
        course.add("Micorservices");
        course.add("AWS");
        course.add("PCF");
        course.add("Azure");
        course.add("DOcker");
        course.add("Kubernetes");

        System.out.println(square_sum(list));
        System.out.println();
        System.out.println(cube_sum(list));
        System.out.println();
        sort_the_no_descending(list);
        System.out.println();
        sort_the_strings_acc_to_length(course);
        System.out.println();
        sort_the_no(list);
        System.out.println();
    }

    private  static int square_sum(List<Integer> no){
//        return no.stream().reduce(0,(x,y)->x+(y*y));
        // using map and reduce
        return no.stream().map(x->x*x).reduce(0,Integer::sum);
    }

    private static int cube_sum(List<Integer> no){
//        return no.stream().reduce(0,(x,y)->x+(y*y*y));
        // using map and reduce
        return no.stream().map(x->x*x*x).reduce(0,Integer::sum);

    }

    private static void sort_the_no(List<Integer> no){
        no.stream().distinct().sorted().forEach(System.out::println);
    }

    private static void sort_the_no_descending(List<Integer> no){
        no.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sort_the_strings_acc_to_length(List<String> no){
        // Custom SOrting according to the length of the String ;)
        no.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }


    private static int odd_sum(List<Integer> no){
//        return no.stream().reduce(0,(x,y)->y%2!=0?x+y:x);

        return no.stream().filter(x->x%2==1).reduce(0,Integer::sum);
    }


    private static  int sum(int aggregate,int nextnumber){
        System.out.println(aggregate+" "+nextnumber);
        return aggregate+nextnumber;
    }

    private static int addListStruct(List<Integer> list) {
        // First parameter for Reduce is Identity value or the starting value ;)
        // Second Parameter is for accumulation

        return list.stream().reduce(0,Integer::max);
                // combine them into one result => One Value
        // 0 and (a,b) -> a+b
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
