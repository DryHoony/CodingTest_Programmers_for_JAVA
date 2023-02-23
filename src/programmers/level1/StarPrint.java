package programmers.level1;

import java.util.Scanner;

public class StarPrint { // 별찍기

    // 직사각형 별찍기
    public static void rectangleStar(int n, int m){ // 가로n 세로m 직사각형
        String star = "*".repeat(n);

        for (int i = 0; i < m; i++) {
            System.out.println(star);
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력받음
        int a = sc.nextInt();
        int b = sc.nextInt();

        rectangleStar(a,b);
    }
}
