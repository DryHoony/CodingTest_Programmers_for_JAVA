import programmers.highScoreKit.Heap.HeapClass;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        HeapClass heap = new HeapClass();
        heap.input(5);
        heap.input(15);
        heap.input(6);
        heap.input(3);
        heap.input(8);
        heap.input(11);
        heap.input(1);
        heap.input(6);


        // 확인
//        System.out.println(heap.toString());
//        while (!heap.isEmpty()){
//            System.out.println("최댓값 출력:" + heap.output() + ", 남은 " + heap.toString());
//        }

        // '우선순위 큐'와 비교해 보자
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(15);
        queue.add(6);
        queue.add(3);
        queue.add(8);
        queue.add(11);
        queue.add(1);
        queue.add(6);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }










    }


}









