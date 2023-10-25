import java.util.*;

public class Test {


    public static void main(String[] args) {

        // visited 에서 출발 격자,방향 탐색(설정), cycle 시작값 설정
        // visited 를 어떻게 계산해야 중복없이 빨라질까?

        // Stack 또는 Queue 에서 바로 뽑아씀 - 출발
        // visited 연산 - Stack or Queue 에서 특정값 제거 가능할까?
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.remove("o"));



    }





    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }

    public static String bracketTranslateReverse(String input){
        input = input.replaceAll("\\{","\\[");
        input = input.replaceAll("}","]");

        System.out.println(input);
        return input;
    }
}









