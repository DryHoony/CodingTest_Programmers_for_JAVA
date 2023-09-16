import java.util.*;

public class Test {

    public static void main(String[] args) {
        bracketTranslate("[\"SOOOL\",\"XXXXO\",\"OOOOO\",\"OXXXX\",\"OOOOE\"]");
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









