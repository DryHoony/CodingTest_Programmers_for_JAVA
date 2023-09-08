import java.util.*;

public class Test {

    public static void main(String[] args) {
        bracketTranslate("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]");
//        bracketTranslateReverse("{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}");

        String str = "[[1, 2], [1, 3], [2, 4], [2, 5], [3, 6], [4, 7], [5, 7], [7, 8]]";
//        bracketTranslate(str);
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









