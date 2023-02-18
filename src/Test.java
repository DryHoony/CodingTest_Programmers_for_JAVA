import programmers.level0.ReverseArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        // ver2 - list를 2개 사용

        int n = 100;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }
        List<Integer> answer = new ArrayList<>();

        int p;
        list.removeIf(q -> q%2==0);

        System.out.println(list);






        }



    }

    



