import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);

        test.remove(0);
        test.remove(0);
        test.remove(0);

        System.out.println(test);




    }


}
