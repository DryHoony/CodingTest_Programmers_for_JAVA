package programmers.highScoreKit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnDoneMarathon { // 완주하지 못한 선수


    public static void main(String[] args) { // ver1 - array 그대로 이용(단, 한명이라는 조건에서만 풀 수 있다.)
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i]))
                System.out.println(participant[i]);
        }

        // participant가 하나 많으므로 for문에서 출력안되면
        System.out.println(participant[participant.length-1]);;
    }

//    public static void main(String[] args) { // ver2 - HashMap 을 이용한 범용적인 풀이
//        // 참가자 중에는 동명이인이 있을 수 있습니다. - 어떻게 해결할까? >> 이 문제는 HashMap 이 적절치 않다!
//
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//
//        Map<String, Boolean> done = new HashMap<>();
//        for (String str:completion){
//            done.put(str,true);
//        }
////        System.out.println(done.get("a")); // false 가 아닌 null 반환
//
//        for (String str:participant){
//            if(done.get(str) == null){
//                System.out.println(str); // 여러명이면 List에 담아 출력,반환
//            }
//        }
//
//
//    }



}
