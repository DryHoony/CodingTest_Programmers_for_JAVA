import java.util.*;

public class Test {


    public static void main(String[] args) {
        String input = "[[-10, 10], [0, 5], [5, 15]]";
        String output = bracketTranslate(input);

        System.out.println(output);



    }

    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        return input;
    }

}









