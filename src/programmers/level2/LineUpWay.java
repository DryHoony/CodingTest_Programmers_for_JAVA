package programmers.level2;


import java.util.ArrayList;

public class LineUpWay { // 줄서는 방법
    public static void main(String[] args) {
        int n = 5; // 20이하 자연수
        long k = 7;

        // 연산용 변수

        ArrayList<Integer> list = new ArrayList<>(); // 줄 세울 숫자 list
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int fi; // Factorial 연산 변수
        long count = 0; // k 도달시 종료

        int[] answer = new int[n];
        int aIndex = 0;
        // list 에 있는 숫자를 answer 에 할당, 그 과정에서 경우의 수 count 에 누적

        // 연산
        // 1. 자릿수 찾기 : count + F(i) <= k 를 만족하는 max(i)값 찾기
        // 2. 자릿수 할당 : list 에서 해당 '위치 값' 제거 및 answer 에 할당
        // 3. count==k 일때까지 1,2 반복 (list 에 원소가 남을 경우 순서 그대로 answer 에 할당 with aIndex)

        while(count < k){
            // 1. 자릿수 찾기
            fi = list.size();
            while (true){
                if(Factorial(fi)+count < k) break;
                else fi--;
            }
            // Factorial(fi) 가 몇번 들어가는지 연산, 'fi-1' 자리에 연산수 만큼 list[index]값 할당

            // 2. 자릿수 할당
            int div = (int) ((k-count)/Factorial(fi));
            answer[aIndex] = list.get(div);
            aIndex++;
            list.remove(div);
            count += Factorial(fi) * div;

            // 중간연산 결과 출력
            System.out.println();
            System.out.println("answer 출력");
            for (int i:answer){
                System.out.print(i + " ");
            }
        }


        System.out.println("답은 = ");
        for (int i:answer){
            System.out.print(i + " ");
        }
    }

    public static long Factorial(int n){
        long a = 1;
        for (int i = 2; i <= n; i++) {
            a *= i;
        }
        return a;
    }

}
