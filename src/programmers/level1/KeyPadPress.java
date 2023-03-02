package programmers.level1;

public class KeyPadPress { // 키패드 누르기, 카카오 인턴십 https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java

    //키패드 거리함수
    public static int d(int a, int b){ // 0->11로 커버
        int x,y;
        if (a==0) x=11;
        else x=a;
        if (b==0) y=11;
        else y=b;

        return Math.abs((x-1)/3 - (y-1)/3) + Math.abs((x-1)%3 - (y-1)%3);
    }

    public static String left(int[] now, int n){
        now[0] = n;
        return "L";
    }
    public static String right(int[] now, int n){
        now[1] = n;
        return "R";
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = "";
        // 초기위치 (*,#)->(10,12) 필요
        int[] now = {10,12};

        for (int n:numbers){
            if(n==1||n==4||n==7){ //왼쪽패드
                answer += left(now,n);
            } else if (n==3||n==6||n==9) { // 오른쪽패드
                answer += right(now,n);
            }else{
                if(d(n,now[0]) < d(n,now[1])){ // 왼손 가까움
                    answer += left(now,n);
                } else if (d(n,now[0]) > d(n,now[1])) { // 오른손 가까움
                    answer += right(now,n);
                }else{ //같은거리
                    if(hand.equals("right")){ // 오른손 잡이
                        answer += right(now,n);
                    }else{ // 왼손 잡이
                        answer += left(now,n);
                    }
                }
            }
        }

        System.out.println(answer);

        System.out.println(d(7,0));
        System.out.println(d(12,0));





    }
}
