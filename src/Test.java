import java.util.*;

public class Test {


    public static void main(String[] args) {


        Random random = new Random();


        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 40; i <= 200; i+=10) {
            int randomN = random.nextInt(5)+1;
            for (int j = 0; j < randomN; j++) {
                arr.add(i);
            }
            System.out.println(i + "갯수 = " + randomN);

        }

        System.out.println(arr);


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









