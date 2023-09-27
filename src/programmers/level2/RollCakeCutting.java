package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class RollCakeCutting { // 롤케이크 자르기

    public static void main(String[] args) {
        int[] topping = {1,2,3,1,4}; // 순서있음
        // 갯수에 상관없이 각 조각에 동일한 가짓수의 토핑으로 나누기
        // Array 를 두 구간으로 나눌때, 각 구간이 가지는 숫자(토핑)의 종류수 가 동일 >> count++;


        // 연산용 변수
        int count=0; // 공평하게 자르는 방법의 수

        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();

        // 초기 - right 에 모두 할당
        for (int i:topping){
            if(right.containsKey(i)){
                right.put(i, right.get(i)+1);
            } else right.put(i,1);

        }

        // 본 연산 - left 에 하나씩 추가, right 에 하나씩 감소
        for (int i:topping){

            // left 에 추가
            if(left.containsKey(i)){
                left.put(i, left.get(i)+1);
            } else left.put(i,1);


            // right 에 제거
            if(right.get(i) == 1){
                right.remove(i);
            }else right.put(i, right.get(i)-1);


            // 갯수 비교! - left 는 늘어나는중, right 는 줄어드는 중
            if(left.size() == right.size()) count++;
            else if (left.size() > right.size()) break;;

        }

        System.out.println("답은 >> " + count);
    }
}
