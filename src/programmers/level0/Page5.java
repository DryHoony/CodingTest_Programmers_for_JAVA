package programmers.level0;

public class Page5 { //5페이지 문제 모음

    int num1 = 60;
    int num2 = 135;


    //연산
    int sum = num1 + num2;
    int dif = num1 - num2;
    int mul = num1 * num2;
    int div = num1 / num2; //정수끼리의 연산은 정수를 반환, 즉 나눈 몫을 반환
    int rest = num1 % num2; // 나눈 나머지(모듈러)

    // 실수연산
    float n1 = num1; // 묵시적 형변환
    float n2 = num2;
    float divF = n1/n2;  // 실수값 그대로 나눗셈 연산
    int divI = (int) divF; // 명시적 형변환


    // 유클리드 알고리즘 - 최소공배수
    public static int getGcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return getGcd(b, a%b);
    }


    //배열
    int[] array1 = new int[3]; //3칸짜리 int타입 배열
//    array1[0] = 1; // 현재 오류가 뜬다. 객체가 생성되지 않은 참조형이 원인인 것으로 추정
//    array1[1] = 2; // main 메소드 내에서 실행한다면 오류가 뜨지 않는다
//    array1[2] = 3;

    int[] array2 = new int[]{1,2,3}; // 위의 array1과 동일하다.




    // 실행 테스트
    public static void main(String[] args){
        Page5 n = new Page5();


        int gcd = getGcd(n.num1, n.num2);

        System.out.println(gcd);



    }

}
