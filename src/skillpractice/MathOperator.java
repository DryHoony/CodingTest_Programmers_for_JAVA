package skillpractice;


import programmers.level0.*;
import programmers.level1.ACipherSum;
import programmers.level1.MainScreenClean;
import programmers.level1.MatrixAdd;

public class MathOperator {

    // Math클래스, 객체생성없이 사용가능

    double e = Math.E; // 오일러 수
    double pi = Math.PI; // 원주율

    // 사직연산
    int n = 10%3; // 모듈러, 나머지
    double powv = Math.pow(2,5);// 제곱
    double sqrtv = Math.sqrt(100); // 제곱근

    int maxv = Math.max(1,2); // 최대값, 두개의 값만 비교
    TwoNumberMaxValue twoMultiple = new TwoNumberMaxValue(); // list에서 두수의 곱의 최댓값
    int minv = Math.min(1,2); // 최솟값
    int absv = Math.abs(-1); // 절댓값
    double floorv = Math.floor(1.5); // 최대정수함수, 가우스함수
//    int floorv = (int)Math.floor(1.5);
    double ceilv = Math.ceil(1.5); // 천장함수
    double roundv = Math.round(1.5); // 반올림

    ACipherSum sum = new ACipherSum(); //자릿수 합


    double ranv = Math.random(); // 0<= x < 1 실수 random 추출
    int ranz = (int) (Math.random()*100); // 0~99 정수 random 추출

    divisor dclass = new divisor(); // 약수

    PrimeNumber pclass = new PrimeNumber();// 소수

    PermutationAndCombination pc = new PermutationAndCombination();// 팩토리얼, 순열, 조합, gcd,lcm

    //진법
    BinarySystem bi = new BinarySystem();// 이진법


    // 도형, 공간
    RectangleArea area = new RectangleArea(); // 직사각형 넓이
    DirectionKey dkey = new DirectionKey(); // 방향키 누름
    SafetyZone safezone = new SafetyZone(); // 격자공간 근방제거 - 킹(거리1)위치 폭탄제거
    MainScreenClean mainScreenClean = new MainScreenClean(); // 격자공간 파일(존재)체크, 직사각형 드래그 연산
    Parallel p = new Parallel(); // 평행, 기울기 비교
    OverlapLine overlap = new OverlapLine();// 겹치는 선분길이


    // 리스트 정렬규칙
    ClosedArrange closed = new ClosedArrange(); // 특정숫자에 가까운 순서로 정렬
    RankArrange rankArrange = new RankArrange(); // 등수정렬

    PolynomialPlus firstDemPol = new PolynomialPlus(); // 다항식

    // 삼각함수


    MatrixAdd mAdd = new MatrixAdd(); //행렬





}
