package programmers.highScoreKit.hash;

import java.util.HashMap;
import java.util.Map;

public class Camouflage { // 위장


    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, // {"의상이름", "의상종류"}
                {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        // 최소 한개의 의상은 입는다. - 모든 경우의수 곱 -1
        Map<String, Integer> cloth = new HashMap<>();

        for (String[] str:clothes){
            if(cloth.containsKey(str[1])){
                cloth.put(str[1],1+ cloth.get(str[1]));
            }else{
                cloth.put(str[1],1);
            }
        }

        //출력
        int answer = 1;
//        System.out.println(cloth.keySet());
        System.out.println(cloth.values());
        for(int i:cloth.values()){
            answer *= i+1;
        }
        System.out.println(answer-1);



    }
}
