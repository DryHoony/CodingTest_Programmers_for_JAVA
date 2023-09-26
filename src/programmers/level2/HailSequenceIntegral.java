package programmers.level2;

import java.util.ArrayList;

import static javax.swing.UIManager.get;

public class HailSequenceIntegral { // 우박수열 정적분

    public static void main(String[] args) {
        int k=3; // 초항
        int[][] ranges={{0,0},{1,-2},{3,-3}};



        // 연산용 변수
        ArrayList<Integer> collatzSequence = new ArrayList<>();
        collatzSequence.add(k);
        int m=k;
        while(m!=1){
            if(m%2==0) m /= 2;
            else m = m*3 +1;
            collatzSequence.add(m);
        }
        System.out.println("collatzSequence = " + collatzSequence);

        int l = collatzSequence.size();
        System.out.println("l = " + l);
        // 각 구간의 넓이 구하기 - 실수형 double
        double[] integral = new double[l-1]; // integral[i] 는 (i,i+1) 의 넓이
        for (int i = 0; i < l-1; i++) {
            integral[i] = ((double)collatzSequence.get(i)+collatzSequence.get(i+1))/2; // 직사각형
        }

        System.out.print("넓이 확인 >> ");
        for (double s:integral){
            System.out.print(s + " ");
        }
        System.out.println();

        double[] answer = new double[ranges.length];

        // 본 연산 - [a,-b] >> (a,l-b) 로 둘러 쌓인 넓이, a > l-b 이면 -1 반환
        for (int i = 0; i < ranges.length; i++) {
//            double result=0;
            int a = ranges[i][0];
            int b = l + ranges[i][1] -1;

            if(a > b) {
//                result=-1;
                answer[i] = -1;
            }
            else {
                for (int j = a; j < b; j++) {
//                    result += integral[j];
                    answer[i] += integral[j];
                }
            }

//            System.out.println(a + "~"+b+" 정적분 결과 >> " + result);
//            answer[i] = result;
            System.out.println(a + "~"+b+" 정적분 결과 >> " + answer[i]);
        }



        System.out.println("답은 >> ");
    }
}
