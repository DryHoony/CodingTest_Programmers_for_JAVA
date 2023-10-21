package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent { // 할인행사

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"}; // 길이 1~10
        int[] number = {3,2,2,2,1}; // want 와 길이 동일, 원소의 합 10
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        // 길이 10 ~ 100,000

        // discount 의 길이가 10만까지이므로 discount 로 여러번 반복문 X


        // 연산용 변수
        int n = discount.length;
        boolean answerFlag;
        int answer=0;


        Map<String, Integer> map = new HashMap<>(); // 10일간 각 품목을 저장
        // 초기화 1~10일
        for (int i = 0; i < 10; i++) {
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])+1);
            }
            else {
                map.put(discount[i],1);
            }

        }
        System.out.println(map);

        // want 비교 연산
        answerFlag = true; // 초기화
        for (int j = 0; j < want.length; j++) {
            if (!map.containsKey(want[j])){ // NullPointException 제어
                answerFlag = false;
                break;
            }
            if(map.get(want[j]) != number[j]){
                answerFlag = false;
                break;
            }

            // 위 if 문을 통과하면 answerFlag = true 유지
        }

        if(answerFlag) answer++; // 해당되면 답에 추가!


        // discount 를 (Index 11 부터) 한번만 스캔 >> map 에 실시간으로 기록하며 연산(want 와 같은지 확인)
        for (int i = 10; i < n; i++) {
            // 이전값 제거
            if(map.get(discount[i-10]) == 1){
                map.remove(discount[i-10]);
            }
            else {
                map.put(discount[i-10], map.get(discount[i-10])-1);
            }

            // 새로운값 추가
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])+1);
            }
            else {
                map.put(discount[i],1);
            }
            System.out.println(map);

            // want 비교 연산
            answerFlag = true; // 초기화
            for (int j = 0; j < want.length; j++) {
                if (!map.containsKey(want[j])){ // NullPointException 제어
                    answerFlag = false;
                    break;
                }
                if(map.get(want[j]) != number[j]){
                    answerFlag = false;
                    break;
                }

                // 위 if 문을 통과하면 answerFlag = true 유지
            }

            if(answerFlag) answer++; // 해당되면 답에 추가!


        }











        System.out.println("답은 = " + answer);
    }


}
