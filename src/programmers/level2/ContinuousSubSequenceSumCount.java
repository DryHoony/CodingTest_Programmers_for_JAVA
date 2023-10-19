package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubSequenceSumCount { // 연속 부분 수열 합의 개수

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4}; // 원형 수열, 길이 3~1000, 값 1~1000


        // 연산용 변수
        Set<Integer> set = new HashSet<>(); // 중복 자동 체크
        int totalSum = 0; // 전체 합
        for (int k:elements){
            totalSum += k;
        }
        int sum;
        int n = elements.length;

        System.out.println("totalSum = " + totalSum);

        // 문제예시처럼 부분수열의 길이 기준 연산
        // 길이 (1,n-1), (2,n-2) 세트로 연산 >> totalSum - sum;
        for (int i = 0; i < n/2; i++) { // 부분수열의 길이 i+1
            System.out.println("부분수열 길이 = " + (i+1) + " 연산 >>>");

            // sum  초기화 = Index 0~i 까지 합
            sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += elements[j];
            }
            // 초기연산
            set.add(sum);
            set.add(totalSum - sum);
            System.out.println("set 추가 >> " + sum + ", " + (totalSum-sum));

            for (int j = 1; j < n; j++) { // 부분수열 출발 index = j
                // 부분수열 연산 - j부터 (j+i) 까지 합
                // 길이 i 인 상태로 평행이동 >> Index(j-1) 뺄셈, Index(j+i) 덧셈
                sum -= elements[j-1];
                if(j+i < n) sum += elements[j+i];
                else sum += elements[j+i-n]; // 한바퀴 돌아옴(순환, 연결)
                set.add(sum);
                set.add(totalSum - sum);
                System.out.println("set 추가 >> " + sum + ", " + (totalSum-sum));

            }



        }

        set.add(totalSum);
        System.out.println(set);
        System.out.println("답은 = " + set.size());
    }
}
