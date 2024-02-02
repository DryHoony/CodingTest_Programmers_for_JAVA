package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Country124 { // 124 나라의 숫자
    // 숫자 124를 이용한 3진법 처럼 표현

    // ver1 - 3진법 변환 ver >> 자릿수가 달라지는 구간이 있다!! 실패!
    public static void main1(String[] args) {
        int n = 13;

        System.out.println("n = " + n);

        // 연산용 변수
        String answer = "";
        ArrayList<Integer> ternaryScale = new ArrayList<>();
        int k;

        // 연산
        // 1. 3진법 변환
        // 2. 3진법 숫자 012 >> 124 변환

        // ternaryScale(3진법) 할당, 역순!!
        while(n>2){
            ternaryScale.add(n%3); // n=1,2 인 경우 못잡는다.
            n /= 3;
        }

        ternaryScale.add(n);
        n /= 3;

        System.out.println("ternaryScale = " + ternaryScale);

        for (int i = ternaryScale.size()-1; i >=0 ; i--) {
            k = ternaryScale.get(i);
            if(k==0){
                answer+="1";
            }else if(k==1){
                answer+="2";
            }else if(k==2){
                answer+="4";
            }
        }



        System.out.println("답은 = " + answer);
    }

    // ver2
    public static void main2(String[] args) {
        int n = 2;
//        System.out.println("n = " + n);
//        System.out.println(change(n));

        for (int i = 1; i < 11; i++) {
            System.out.print("i = " + i + " >> ");
            System.out.println(change(i));
        }

    }

    public static String change(int n){
        String answerReverse = "";
        int k;
        n--;
//        System.out.println("출력 test");

        while(n>0){
            k = n%3;
            if(k==1){
                answerReverse += "2";
//                System.out.println("1 할당");
            }else if (k==2){
                answerReverse += "4";
//                System.out.println("2 할당");
            }else if (k==0){
                answerReverse += "1";
//                System.out.println("4 할당");
            }

            n /= 3;
            n--;
//            System.out.println("3나누고 남은 n = " + n);
        }

        String answer = "";
        for (int i = answerReverse.length()-1; i >= 0; i--) {
            answer += answerReverse.charAt(i);
        }

        return answer;
    }

    // ver3
    public static void main3(String[] args) {
        int n=1;
        System.out.println("n = " + n);
        int i = 1; // 자릿수

        // 자릿수 결정
        while (threeSeries(i) < n){ // n <= threeSeries(i) 만족
            i++;
        }
        System.out.println("자릿수 i = " + i);

        // 필기값 i=4

        String answer = "";
        int k;
        while (i>1){
            // 각 자릿수 연산 3^(i-1)가 몇번 들어갈 수 있나 = k
//            k = (n-threeSeries(i-1))/((int) Math.pow(3,i-1)); // 핵심 연산!!
//            System.out.println(n-threeSeries(i-1) + " 에서 " + (int) Math.pow(3,i-1) + " 이 몇번 들어가냐? >> ");
            k = (n-threeSeries(i-1)+2)/((int) Math.pow(3,i-1));

            System.out.println("3진법 자릿수 k = " + k);
            n -= k*((int) Math.pow(3,i-1));
            System.out.println("남은 n = " + n);


            if(k==1){
                answer += "1";
            }else if(k==2){
                answer += "2";
            }else if(k==3){
                answer += "4";
            }
            System.out.println("할당된 answer = " + answer);
            i--;
        }

        // 마지막 자릿수 연산 따로 - %연산 등에서 오류난다
        if(n==1){
            answer += "1";
        }else if(n==2){
            answer += "2";
        }else if(n==3){
            answer += "4";
        }

        System.out.println();
        System.out.println("answer = " + answer);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 200; i++) {
            System.out.print("i = " + i + " >> ");
            System.out.println(solutionVer3(i));
        }

//        System.out.println();
//        System.out.println("13 test"); // 111
//        System.out.println(solutionVer3(13));
    }

    public static String solutionVer3(int n){
        int i = 1; // 자릿수

        // 자릿수 결정
        while (threeSeries(i) < n){ // n <= threeSeries(i) 만족
            i++;
        }
//        System.out.println("자릿수 i = " + i);

        // 필기값 i=4

        String answer = "";
        int k;
        while (i>1){
            // 각 자릿수 연산 3^(i-1)가 몇번 들어갈 수 있나 = k
//            k = (n-threeSeries(i-1))/((int) Math.pow(3,i-1)); // 핵심 연산!!
//            System.out.println(n-threeSeries(i-1) + " 에서 " + (int) Math.pow(3,i-1) + " 이 몇번 들어가냐? >> ");

            k = (n-threeSeries(i-1)+(int)Math.pow(3,i-1)-1)/((int) Math.pow(3,i-1));
//            System.out.println(n-threeSeries(i-1) + " 에서 " + (int) Math.pow(3,i-1) + " 이 몇번째에 들어가냐? >> ");
//            System.out.println("3진법 자릿수 k = " + k);
            n -= k*((int) Math.pow(3,i-1));
//            System.out.println("남은 n = " + n);


            if(k==1){
                answer += "1";
            }else if(k==2){
                answer += "2";
            }else if(k==3){
                answer += "4";
            }
//            System.out.println("할당된 answer = " + answer);
            i--;
        }

        // 마지막 자릿수 연산 따로 - %연산 등에서 오류난다
        if(n==1){
            answer += "1";
        }else if(n==2){
            answer += "2";
        }else if(n==3){
            answer += "4";
        }

        return answer;
    }

//    public static void main(String[] args) {
//        for (int i = 1; i < 6; i++) {
//            System.out.print("i = " + i + " >> ");
//            System.out.println(threeSeries(i));
//        }
//    }

    public static int threeSeries(int k){
        return ((int) Math.pow(3,k)-1)/2*3;
    }
}
