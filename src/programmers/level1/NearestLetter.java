package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class NearestLetter { // 가장 가까운 글자


    public static void main(String[] args) {
        String s = "foobar";

        Map<Character, Integer> map = new HashMap<>();
        int l = s.length();
        int[] answer = new int[l];

        for (int i = 0; i < l; i++) {
            if(map.containsKey(s.charAt(i))){ // 있으면
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i),i); // index update
                System.out.println(answer[i]); // 확인용
            }else{ // 없으면
                answer[i] = -1;
                map.put(s.charAt(i),i); // index 할당

                System.out.println(answer[i]); // 확인용
            }
        }

        //결과


    }
}
