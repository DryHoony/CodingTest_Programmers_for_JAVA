package programmers.level2;

public class BilliardsPractice { // 당구연습
    // 쿠션 연습 - 적어도 한번은 벽에 맞춤
    // 회전(히네루)없음, 점으로 인식, 일치할때 맞춘것, 꼭지점에 부딪힐 경우 집입 방향의 반대방향으로 진행
    // 목표에 맞기 전까지 멈춤X
    // 거리의 최솟값의 제곱[] 을 return >> 정수 범위 맞출려는듯


    public static void main(String[] args) { // (36개중)8개 실패 >> 해결,,논리는 맞는데 변수명이 틀려서,,,
        // 당구대 가로, 세로 3~1000
        int m=10;
        int n=10;
        // 쳐야 하는 공 위치(정수), 테두리 경계에 주어지진 않는다
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7,7},{2,7},{7,3}}; // 매 회다마 목표로 해야 하는 공 위치, 테두리 경계에 주어지진 않는다
        // 2~1000

        // 연산용 변수
        int N = balls.length;
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            // i번째 연산
            int minD = Integer.MAX_VALUE;
            int distance;
            int a = balls[i][0];
            int b = balls[i][1];

            // 대칭(원쿠션) - 위,아래, 왼, 오
            if( !(a==startX && b<startY) ){ // 위
                distance = 0;
                distance += Math.pow(startX-a,2); // 가로
                distance += Math.pow(startY+b,2); // 세로
                minD = Math.min(minD, distance);

            }
            if( !(a==startX && startY<b) ){ // 아래
                distance = 0;
                distance += Math.pow(startX-a,2); // 가로
                distance += Math.pow(2*n-b-startY,2); // 세로

                minD = Math.min(minD, distance);
            }
            if( !(a<startX && b==startY) ) { // 왼쪽
                distance = 0;
                distance += Math.pow(a+startX,2); // 가로
                distance += Math.pow(startY-b,2); // 세로


                minD = Math.min(minD, distance);
            }
            if( !(startX<a && b==startY) ) { // 오른쪽
                distance = 0;
                distance += Math.pow(2*m-a-startX,2); // 가로
                distance += Math.pow(startY-b,2); // 세로

                minD = Math.min(minD, distance);
            }


            System.out.println(startX+" "+startY+" 에서 " +a+" "+b+" 까지 거리 >> "+ minD);
            // 최솟값 할당
            result[i] = minD;

        }




        System.out.println("답은 >>" + result);
    }


}
