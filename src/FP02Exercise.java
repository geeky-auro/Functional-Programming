import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Good, List of String

        list.add(15);
        list.add(15);
        list.add(15);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(1);
        list.add(95);
        list.add(95);
        list.add(95);
        list.add(101);

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

        int sum=addListStruct(list);
        System.out.println(sum);
        System.out.println("Every Number Square and Sum : "+square_sum(list));
        System.out.println("Cube Sum : "+cube_sum(list));
        System.out.println("Odd Sum : "+odd_sum(list));
//        System.out.println("Distinct Numbers \n"+distinct(list));
        distinct(list);
        /***
         * Exercise
         *
         * Square every number in a list and find the sum of squares
         *
         * Exercise
         *
         * Cube every number in a list and find the sum of cubes
         *
         * Exercise
         *
         * Find sum of Odd Numbers in a list
         *
         */

        // To print out distinct Numbers we can use something called as distinct

        // SOrt the numbers
        sort_the_no(list);
        sort_the_no_descending(list);

        System.out.println();
        System.out.println(new FP02Exercise().create_even_no_ist(list));
        System.out.println(create_len_list(course));
    }

    private static int sum(int aggregate,int nextnumber){
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

    private static  void distinct(List<Integer> no){
        no.stream().distinct().forEach(System.out::println);
    }

    private static void printAllNumbersInListStructures(List<Integer> list) {

        for (int x:list){
            System.out.println(x);
        }

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
        no.stream().distinct().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }


    private static int odd_sum(List<Integer> no){
//        return no.stream().reduce(0,(x,y)->y%2!=0?x+y:x);

        return no.stream().filter(x->x%2==1).reduce(0,Integer::sum);
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


    private List<Integer> create_even_no_ist(List<Integer> no){
        return no.stream().filter(t->t%2==0).collect(Collectors.toList());
    }

    private static List<Integer> create_len_list(List<String> str){
        return str.stream().map(t->t.length()).collect(Collectors.toList());
    }

}
