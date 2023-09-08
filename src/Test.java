import java.util.*;

public class Test {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); // dfs 연산용 Queue
        Queue<Integer> nextQueue = new LinkedList<>(); // 다음 레벨 구분용 Queue


        nextQueue.add(1);
        nextQueue.add(2);
        nextQueue.add(3);

        System.out.println("queue = " + queue);
        System.out.println("nextQueue = " + nextQueue);
        System.out.println("nextQueue 값을 queue 에 주고 clear 테스트");
        System.out.println();

        queue.addAll(nextQueue);
        nextQueue.clear();
        System.out.println("queue = " + queue);
        System.out.println("nextQueue = " + nextQueue);



    }






    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }
}









