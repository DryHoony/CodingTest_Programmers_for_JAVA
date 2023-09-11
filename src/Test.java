import java.util.*;

public class Test {

    static int answer=0; // 얘도 소용없네
    static int outValue=0;

    public static void main(String[] args) {

//        int answer=0; // dfs 연산밖에서도 값이 유지되나?
//        int outValue=0;
        dfs(0);
//        System.out.println("answer 의 결과값은? = "+answer);
        System.out.println("outValue = " + outValue);

    }

    public static void dfs(int node){
        if(node ==5){
//            System.out.println("메소드 내부에서 answer = " +answer);
            return;
        }

        outValue++;
        dfs(node+1);


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









