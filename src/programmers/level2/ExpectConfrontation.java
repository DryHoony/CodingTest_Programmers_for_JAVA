package programmers.level2;

public class ExpectConfrontation { // 예상 대진표 (2017 팁스타운)

    public static void main(String[] args) {
        // Input
        int n = 8;
        int a = 4;
        int b = 7;

        // 연산용 변수
        int k; // 차이값
        if(a > b){
            k = a;
            a = b;
            b = k;
        }
        k = b-a;

        int x = 1; // 답, 2^x 연산 변수
        while (k >= Math.pow(2,x)){ // 초기 탐색 범위 설정
            x++;
        }

        // 연산

        while (true){ // break 부분을 return 으로 변경할것

            if( (int)((a-1)/Math.pow(2,x)) == (int)((b-1)/Math.pow(2,x))){
                System.out.println("x = " + x);
                break;
            }
            x++;
        }



        System.out.println("답은 = " + x);
    }

}
