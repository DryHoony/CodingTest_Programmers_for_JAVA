package programmers.highScoreKit.exhaustiveSearch;

public class Carpet { // 카펫


    public static void main(String[] args) {
        int brown = 10; // 8~5000 테두리
        int yellow = 2; // 1~2,000,000 내부
        // [가로, 세로] return, 가로>=세로


        int a,b; // 노란색 가로,세로
        b=1;
        a=yellow;

        // 새로운 가로,세로 길이 - yellow 연산
//        b++;
//        while(yellow%b!=0){
//            b++;
//        }
//        a = yellow/b;

        // brown 연산
        while((a+2)*(b+2) != yellow+brown){
            // 맞출때까지 새로운 가로,세로 길이 - yellow 연산
            b++;
            while(yellow%b!=0){
                b++;
            }
            a = yellow/b;

        }

        System.out.println(a+2);
        System.out.println(b+2);






    }
}
