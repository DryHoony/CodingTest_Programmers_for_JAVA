package skillpractice;


import programmers.level0.PermutationAndCombination;
import programmers.level0.divisor;

public class MathOperator {

    // Math클래스, 객체생성없이 사용가능

    double e = Math.E; // 오일러 수
    double pi = Math.PI; // 원주율

    double powv = Math.pow(2,5);// 제곱
    double sqrtv = Math.sqrt(100); // 제곱근

    int maxv = Math.max(1,2); // 최대값, 두개의 값만 비교
    int minv = Math.min(1,2); // 최솟값
    int absv = Math.abs(-1); // 절댓값
    double floorv = Math.floor(1.5); // 최대정수함수, 가우스함수
//    int floorv = (int)Math.floor(1.5);
    double ceilv = Math.ceil(1.5); // 천장함수
    double roundv = Math.round(1.5); // 반올림



    double ranv = Math.random(); // 0<= x < 1 실수 random 추출
    int ranz = (int) (Math.random()*100); // 0~99 정수 random 추출


    // 삼각함수


    // 약수의 갯수
    divisor dclass = new divisor();

    // 소수

    PermutationAndCombination pc = new PermutationAndCombination();// 팩토리얼, 순열, 조합, gcd



}
