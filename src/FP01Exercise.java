import java.util.ArrayList;
import java.util.List;

public class FP01Exercise {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Good, List of String

        list.add(15);
        list.add(20);
        list.add(30);
        list.add(168);
        list.add(95);
        list.add(98);
        list.add(100);
        list.add(292);

        /**
         *
         * Exercise 1 ;-
         * Print Only Odd Numbers from the list
         *
         * Exercise 2 :-
         * Print all COurses Individually
         *
         * List<String> courses=List.of("Spring", "Spring Boot", "AWS", "Micorservices", "AWS", "PCF", "Azure", "DOcker", "Kubernetes");
         *
         * Exercise 3:-
         *
         * Print Courses Containing the word "Spring"
         *
         * Exercise 4:-
         *
         * Print Courses Whose Name has atleast 4 letters
         *
         *
         * Exercise 5:-
         *
         * Print the length of each string
         * */
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

//        System.out.println("Hwllo is there anyone ".indexOf("ithere"));
        new FP01Exercise().oddNums(list);
        new FP01Exercise().courses(course);
        new FP01Exercise().selectSpring(course);
        new FP01Exercise().atleast4(course);
        new FP01Exercise().leng(course);
         }

         private void oddNums(List<Integer> nums){
            nums.stream().filter(no->(no%2!=0)).forEach(System.out::println);
         }

         private void courses(List<String> course){
            course.forEach(System.out::println);
         }

         private void selectSpring(List<String> course){
            course.stream().filter(str->(str.indexOf("Spring")!=-1)).forEach(System.out::println);
            course.stream().filter(str->(str.contains("Spring"))).forEach(System.out::println);
         }

         private void atleast4(List<String> course){
             course.stream().filter(str->(str.length()>=4)).forEach(System.out::println);

         }

         private void leng(List<String> course){

            course.stream().map(String::length).forEach(System.out::println);

         }

}