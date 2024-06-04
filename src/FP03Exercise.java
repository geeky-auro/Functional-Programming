import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class FP03Exercise {
    public static void main(String[] args) {
        /**
         * * Find Functional Interface behind the second argument of reduce method.
         * Create an implementation for the Functional Interface.
         * */

        List<Integer> num=new ArrayList<>();
        num.add(45);
        num.add(55);
        num.add(35);
        num.add(75);
        num.add(85);
        num.add(95);
        num.add(105);
        int sum=num.stream().reduce(0,Integer::sum);
        // Operations such as Maximum of two number's , Minimum of two number's
        // Functional Descriptor of all lambda function remains same !
        BinaryOperator<Integer> b=new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };

    }
}
