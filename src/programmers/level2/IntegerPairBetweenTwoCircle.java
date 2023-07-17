package programmers.level2;

public class IntegerPairBetweenTwoCircle { // 두 원사이의 정수 쌍
    // https://school.programmers.co.kr/learn/courses/30/lessons/181187


    public static void main(String[] args) { // 7~10 실패!! >> int 범위로 연산안됨, long 타입으로 해결!!
        int r1 = 2;
        int r2 = 3;
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            answer += yCount(i, r2);
        }
        for (int i = 1; i <= r1; i++) {
            answer -= yCountOpen(i, r1);
        }

        answer *= 4;
        // 결과 출력
        System.out.println(answer);

    }

    // x값에 따른 y값 - 격자점 on y>=0
    public static long yCount(long x, long r){
        double y = Math.sqrt(r*r - x*x);
        long yInteger = (long) y;

        return yInteger+1;
    }
    public static long yCountOpen(long x, long r){ // 경계 미포함
        double y = Math.sqrt(r*r - x*x);
        long yInteger = (long) y;

        if(y == yInteger){
            return yInteger;
        }else {
            return yInteger+1;
        }
    }



}
