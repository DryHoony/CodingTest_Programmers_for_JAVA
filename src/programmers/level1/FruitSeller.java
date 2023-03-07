package programmers.level1;


import java.util.HashMap;
import java.util.Map;

public class FruitSeller { // 과일장수


    public static void main(String[] args) {
        int k = 4; // 사과의 점수 1~k
        int m = 3; // 한 상자에 사과 m개
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        // 상자의 가격은 min(k) * m (상자단위 판매, 남은사과 버림)

        int answer = 0; //이익

        // score의 길이가 1,000,000까지 이므로 arrays.sort()말고 'Map을 써보자'가 아니라 list써도 될듯
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 1; i <= k; i++) { //초기화
//            map.put(i,0);
//        }
        int[] count = new int[k];
        for (int i = 0; i < k; i++) { //초기화
            count[i]=0;
        }

        for(int s:score){
            count[s-1]++;
        }

        int remain = 0;
        int num;
        for (int i = k-1; i >= 0; i--) {
            num = count[i] + remain; // (i+1)점 사과 갯수
            answer += (num/m) * m * (i+1); // 이익추가
            remain = num%m; // 다음사과로 이월
        }

        System.out.println(answer);





    }
}
