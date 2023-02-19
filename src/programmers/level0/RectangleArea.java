package programmers.level0;

public class RectangleArea { // 직사각형 넓이 구하기

    // 평면상의 xy축에 평행한 직사각형의 넓이
    public static int area(int[][] dots){
        // 대각의 위치하는 점을 찾아 가로*세로 계산
        int[] dot1 = dots[0];
        int[] dot2;

        for (int i = 1; i < 4; i++) {
            dot2 = dots[i];
            if (dot1[0]!=dot2[0] && dot1[1]!=dot2[1]){
                return Math.abs(dot1[0]-dot2[0]) * Math.abs(dot1[1]-dot2[1]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
