import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Test {


    public static void main(String[] args) {
//        for (; ;) {
//            System.out.println("무한루프 test");
//        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i-- + " 무한루프 test");
//        }

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









