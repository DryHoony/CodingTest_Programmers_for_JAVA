package programmers.level1;

public class CokeProblem { //콜라문제
    // 빈병2개 = 콜라1병 의 일반화 >> 빈병 a개 = 콜라 b병


    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;

        int answer=0;
        while(n/a>0){
            answer += (n/a) * b;
            n = n%a + (n/a) * b;
        }

        System.out.println(answer);

    }


}
