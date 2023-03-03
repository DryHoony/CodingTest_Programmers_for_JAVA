package skillpractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetClass {


    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(5);
//        set.add(2);
//        System.out.println(set);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(1);
        System.out.println(list);

        Set<Integer> set = new HashSet<>();
        set = Set.copyOf(list); // List를 Set으로 변환, list는 그대로(변화X)
//        list = List.copyOf(set); // Set을 List로 변환
        System.out.println(set);
//        Set<Integer> set = new HashSet<>();
//        set.addAll(list);
//        System.out.println(set);


    }
}
