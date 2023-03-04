import java.util.*;

public class Test {


    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        Object[] result = set.toArray();
        int[] answer = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            answer[i] = (int) result[i];
        }

    }

    }

    



