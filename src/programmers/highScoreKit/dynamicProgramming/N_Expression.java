package programmers.highScoreKit.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class N_Expression { // N으로 표현
    // 5~8 실패 >> 수정ver 으로 통과!!
    // 점화식을 꼼꼼하게 점검하자! >> 예시 연산을 통해 확인, 점검 필요!!

    public static void main(String[] args) {
        int N = 8;
        int number = 5800;
        // N과 사칙연산을 통해 number 만들기, 나누기 연산에서 나머지는 무시
        // 88*8*8 + 88 + 88 - 8 = 5800 >> count = 9

        // 연산용 변수
        int count=0;
        ArrayList<Set<Integer>> memoList = new ArrayList<>();
        Set<Integer> memo0 = new HashSet<>();
        Set<Integer> memoa = new HashSet<>();
        Set<Integer> memob = new HashSet<>();

        // 1항 설정
        memo0.add(N);
        memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
        count++;
        if(memo0.contains(number)){
            System.out.println("1항에 걸려서 답은 = " + count);
//            return count;
        }
        System.out.println(count + "번째 memo0 = " + memo0);

        // 2항 설정
        memo0.clear();
        memo0.add(0);
        memo0.add(1);
        memo0.add(2*N);
        memo0.add(N*N);
        memo0.add(10*N + N); // 두자릿 수 "NN"
        memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
        count++;
        if(memo0.contains(number)){
            System.out.println("2항에 걸려서 답은 = " + count);
//            return count;
        }
        System.out.println(count + "번째 memo0 = " + memo0);

        // 점화식 memo(n) = f(memo(n-1)) + f(memo(n-2)) + ... + f(memo(1)) // 모든 연산 계산


        while(!memo0.contains(number)){ // number 찾으면 종료조건
            memo0.clear();
            count++;
            if(count == 9) break; // 최솟값이 8보다 크면 -1 return

            //★ count 절반에 해당하는 범위로 점화식 연산 while문
            for (int i = 0; i < count/2; i++) {
//                memoa.clear(); // memoList 를 제거하면 안되지
//                memob.clear();

                memoa = memoList.get(i);
                memob = memoList.get(count-2-i);


                // memoa, memob 로 memo0 생성
                for (int a:memoa){
                    for (int b:memob){
                        memo0.add(a+b); // 덧셈
                        if(a+b == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                        if(a>b) memo0.add(a-b); // 뺄셈
                        if(a-b == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                        if(b>a) memo0.add(b-a); // 뺄셈(역순)
                        if(b-a == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                        memo0.add(a*b); // 곱셈
                        if(a*b == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                        if(b!=0) memo0.add(a/b); // 나눗셈
                        if(b!=0) if(a/b == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                        if(a!=0) memo0.add(b/a); // 나눗셈(역순)
                        if(a!=0) if(b/a == 2) System.out.println("a,b = " + a + "," + b); // 확인용
                    }
                }
            }

            // count 자리수 만들기
            memo0.add(((int) Math.pow(10,count) - 1)/9 * N);
            memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
            System.out.println(count + "번째 memo0 = " + memo0);

        }

        if(count == 9){
            System.out.println("최솟값이 8보다 크면 -1 return");
        }
        else System.out.println("답은  = "+ count);

    }

    public static void main0(String[] args) {
        int N = 8;
        int number = 5800;
        // N과 사칙연산을 통해 number 만들기, 나누기 연산에서 나머지는 무시
        // 88*8*8 + 88 + 88 - 8 = 5800 >> count = 9

        // 연산용 변수
        int count=0;
        ArrayList<Set<Integer>> memoList = new ArrayList<>();
        Set<Integer> memo0 = new HashSet<>();

        // 1항 설정
        memo0.add(N);
//        memoList.add(memo0);
        memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
        count++;
        if(memo0.contains(number)){
            System.out.println("1항에 걸려서 답은 = " + count);
//            return count;
        }
        System.out.println(count + "번째 memo0 = " + memo0);

        // 2항 설정
        memo0.clear();
        memo0.add(0);
        memo0.add(1);
        memo0.add(2*N);
        memo0.add(N*N);
        memo0.add(10*N + N); // 두자릿 수 "NN"
//        memoList.add(memo0);
        memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
        count++;
        if(memo0.contains(number)){
            System.out.println("2항에 걸려서 답은 = " + count);
//            return count;
        }
        System.out.println(count + "번째 memo0 = " + memo0);

        // 점화식 memo(n) = f(memo(n-1)) + f(memo(n-2))

        while(!memo0.contains(number)){ // number 찾으면 종료조건
            memo0.clear();
            count++;
//            if(count == 9) break; // 최솟값이 8보다 크면 -1을 return

            // 점화식 연산(count-2) >> index는 count-3
            for(int k:memoList.get(count-3)){
                memo0.add(k+1);
                if(k-1 > 0) memo0.add(k-1); // 자연수 범위만
            }

            // 점화식 연산(count-1) >> index는 count-2
            for(int k:memoList.get(count-2)){
                memo0.add(k+N); // 덧셈
                if(k-N > 0) memo0.add(k-N); // 뺄셈
                memo0.add(k*N); // 곱셈
                memo0.add(k/N); // 나눗셈 - 나머지 무시
            }

            // count 자리수 만들기
            memo0.add(((int) Math.pow(10,count) - 1)/9 * N);

//            memoList.add(memo0);
            memoList.add(Set.copyOf(memo0)); // 깊은복사 대체
            System.out.println(count + "번째 memo0 = " + memo0);
            // while 문 조건 >> 종료조건

        }

        if(count == 9){
            System.out.println("최솟값이 8보다 크면 -1을 return");
        }
        else System.out.println("답은 = " + count);

    }

}
