import java.util.*;

public class Test {


    public static void main(String[] args) {

        int n = 3;
        int[] discount = new int[3];
        for (int i = 0; i < n; i++) {
            discount[i] = 1;
        }

        dfs(discount, 0);





    }

    public static void dfs(int[] discount, int i){

        if(discount.length == i){
            System.out.print("출력 >> ");
            for (int j = 0; j < discount.length; j++) {
                System.out.print(discount[j] + ", ");
            }
            System.out.println();
            return;
        }

        // i 연산 후 재귀
//        dfs(discount, i+1); // 1
//        discount[i] += 1;
//        dfs(discount, i+1); // 2
//        discount[i] += 1;
//        dfs(discount, i+1); // 3
//        discount[i] += 1;
//        dfs(discount, i+1); // 4

        dfs(Arrays.copyOf(discount, discount.length), i+1);
        discount[i] += 1;
        dfs(Arrays.copyOf(discount, discount.length), i+1);
        discount[i] += 1;
        dfs(Arrays.copyOf(discount, discount.length), i+1);
        discount[i] += 1;
        dfs(Arrays.copyOf(discount, discount.length), i+1);


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









