import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {
    public static void main(String[] args) {
        List<Integer> num=new ArrayList<>();
        num.add(45);
        num.add(55);
        num.add(35);
        num.add(75);
        num.add(85);
        num.add(95);
        num.add(105);

        Predicate<Integer> isEven=x->x%2==0;

        num.stream().filter(isEven)
                .forEach(System.out::println);

        Predicate<Integer> isOdd=x->x%2!=0;


        num.stream().filter(isOdd)
                .forEach(System.out::println);

        // Passing behaviour in the method  is called Behavious Parameterization!
        // We are passing the programming logic or algorithm in the parameter
        List<Integer> evenNum=mapAndCreate(num,x->x%2);
        List<Integer> cubedNum=mapAndCreate(num,x->x*x*x);


        List<String> courses = new ArrayList<String>();
        courses.add("ZOLO BONANZA");
        courses.add("ZOLO GALA");
        courses.add("ZOLO ZEROHURT");
        courses.add("ZOLO PERIMETER");
        courses.add("ZOLO DEVOLIPO");
        courses.add("ZOLO NUTANIX");
        courses.add("ZOLO CRIO");


        courses.stream()
                .map(String::toLowerCase)
                .forEach(FP03BehaviourParameterization::print);

    }

    private static List<Integer> mapAndCreate(List<Integer> nums,
                                              Function<Integer,Integer> mappingFunction){
        return nums.stream().map(mappingFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> nums,Predicate<Integer> predicate){
        nums.stream()
                .filter(predicate)
                .forEach(System.out::println);

    }



    private void recap(){
        // Function
        /*
        Predicate ->
         A functional interface that represents a boolean-valued function of one argument.
         It is defined in the java.util.function package and has a single abstract method called test().
         The test() method takes an argument of a specific type and returns a boolean value.
        Predicate<Integer> isEven=x->x%2==0;

        num.stream().filter(isEven)
                .forEach(System.out::println);

        Predicate<Integer> isOdd=x->x%2!=0;

        Function -> takes something as the input and produces something as the output
        ex: Function<Integer,String> -> takes Int as the Input and returns String as the Output

         Consumer -> Takes Something as Input but doesn't return anything back!
         ex: Consumer<Integer> sysoutCOnsumer=x-> System.out.println(x);
         Typically we require Consumer when we get Input and wan't to process it !
         not intended to return any output!

         BinaryOperator<Integer> -> takes two number and performs operation
         Ex: We can numbers in a list!

         BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y
         // All the inputs and the outputs should be of same type!
         // Two Integer Input and should return one Output

         Supplier -> When we dont have any input but we wan't to return something back
         Supplier<Integer> randomIntegerSupplier = () -> 2

         Code Example :-
         Supplier<Integer> randomIntegerSupplier =()->2;
         System.out.println(randomIntegerSupplier.get());

         */

        Supplier<Integer> randomIntegerSupplier =()->2;
        System.out.println(randomIntegerSupplier.get());
        Supplier<Integer> randomIntegerSupplier_randomNum =()->{
            Random random=new Random();
            return random.nextInt(10);
        };

        /*
        Unary Operator<Integer> just like Binary Operator functionality it takes one parameter as the Input
        and return one answer as the output!

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        sysout(unaryOperator.apply());
         */

        UnaryOperator<Integer> unaryOperator=(x)->x+2;
        System.out.println(unaryOperator.apply(5));

        /*
        BiPredicate<Integer,String>
        * This interface is packaged in java.util.function package.
        * It operates on two objects and returns a predicate value based on that condition.
        * It is a functional interface and thus can be used in lambda expression also.

        Some Methods are :-
        test()
        and()
        negate()
        or()
        * */
        BiPredicate<Integer,String> biPredicate=(number,str)->{
            return true;
        };

        BiPredicate<Integer,String> biPredicate1 = (number,str) ->{
          return number<10 && str.length()>5;
        };

        System.out.println(biPredicate1.test(5,"HELLOI"));


        /*
        * BiFunction
        * The BiFunction interface in Java is a functional interface that takes two arguments and returns a result.
        * */

        BiFunction<Integer,String,String> biFunction=(number,str)->{
            return number.toString()+" "+str;
        };

        System.out.println(biFunction.apply(3,"Hello"));

        /*
        * It represents a function that takes in two arguments and produces a result.
        * However, these kinds of functions doesn’t return any value.
        * */

        BiConsumer<String,String> biConsumer=(s1,s2) ->{
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept("Hello","Hi");

        /*
        * Primitive Lambda Expression!!
        *Represents an operation upon two int -valued operands and producing an int -valued result.
        * This is the primitive type specialization of BinaryOperator for int .
        * This is a functional interface whose functional method is applyAsInt(int, int) .
        * */

        IntBinaryOperator intBinaryOperator = (x,y) -> x*y;

//        Consumer<String> consumer=()->{};
//        Consumer<String> consumer=(str)->{};
//        Consumer<String> consumer=System.out::println;
        BiConsumer<String,String> consumer=(str,str2) -> {System.out.println(str);};
        Supplier<String> supplier =() ->{return "AURO";};

        /*
        * We can do Type Inference Inside Lambda Expression
        * BinaryOperator -> (x,y) -> x+y;
        * BinaryOperator<Integer> b=(Integer k1,Integer k2)-> k1*k2;

         * */

        BinaryOperator<Integer> b=(Integer k1,Integer k2)-> k1*k2;

        /*
        * Exploring Something more on Method References:-
        * */
        List<String> courses = new ArrayList<String>();
        courses.add("ZOLO BONANZA");
        courses.add("ZOLO GALA");
        courses.add("ZOLO ZEROHURT");
        courses.add("ZOLO PERIMETER");
        courses.add("ZOLO DEVOLIPO");
        courses.add("ZOLO NUTANIX");
        courses.add("ZOLO CRIO");

        courses.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        // In for each we can also call static reference !


        courses.stream()
                .map(String::toLowerCase)
                .forEach(FP03BehaviourParameterization::print);

        // Constructor Reference
        Supplier<String> stringSupplier=()->new String();
        Supplier<String> stringSupplier1= String::new;




    }

    private static void print(String s){
        System.out.println(s);
    }




}
