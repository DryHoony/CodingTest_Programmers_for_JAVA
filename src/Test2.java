import java.util.*;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=10; i>0; i--){
            map.put(i,i);
        }

        map.put(20,20);

        System.out.println(map.keySet());





    }







}
