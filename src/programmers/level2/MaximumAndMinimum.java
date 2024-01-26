package programmers.level2;

public class MaximumAndMinimum { // 최댓값과 최솟값

    public static void main(String[] args) {
//        String s = "1 2 3 4";
        String s = "-1 -2 -3 -4";

        int x;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 연산
        for (String n:s.split(" ")){ // 공백 한칸으로 분리되어 있을까?
            x = Integer.parseInt(n);
//            System.out.println(x);
            if(x < min) min = x;
            if(x > max) max = x;
        }

        //String 변환
        String answer = min + " " + max;

        System.out.println("답은 = " + answer);
    }
}
