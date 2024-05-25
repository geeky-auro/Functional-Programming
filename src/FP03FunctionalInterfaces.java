import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> num=new ArrayList<>();
        num.add(45);
        num.add(55);
        num.add(35);
        num.add(75);
        num.add(85);
        num.add(95);
        num.add(105);

        Predicate<Integer> isEvenPredicate=x->x%2==0;
        // Predicate is responsible for creating and checking of logic
        // It is responsible for sending either a true or a false value.
        // Exact Definition : Evaluates this predicate on the given argument.
        // Below is the actual implementation!
        Predicate<Integer> isEvenPredicate1=new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };
        Function<Integer,Integer> squareFunction=x->x*x;
        // Represents a function that accepts one argument and produces a result.
        // Suppose we have one input and one output and we need to produce something than we go for a function.
        Function<Integer,Integer> squareFunction2=new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };
        Consumer<Integer> sysoutConsumer = System.out::println;
//      Represents an operation that accepts a single input argument and returns no result.
//      Unlike most other functional interfaces,
//      Consumer is expected to operate via side-effects.

        Consumer<Integer> sysout1=new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        // in brief ;-
        num.stream()
                .filter(isEvenPredicate)
                .map(squareFunction2)
                .forEach(sysout1);
        // filter -> we use a condition and filter out things
        // map -> takes input and customizes it
        // consumer -> takes input and consumes it, does't return anything!

    }
}
