import programmers.highScoreKit.Heap.MInHeapClass;
import programmers.highScoreKit.Heap.MaxHeapClass;
import programmers.level0.ReverseArray;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
//        int[] test = {2,5,6,78,4,2,6,4,4,2,5,5,9,7,26,416,5,498,746,24,9,7,5,4,9,11,1,3,3,4,4,879,5};
        int[] test = {9,8,7,6,10,70,5,4,3,2,1,0};

//        MInHeapClass heap = new MInHeapClass();
        MaxHeapClass heap = new MaxHeapClass();


        for (int i:test){
            heap.input(i);
        }

        Arrays.sort(test); // 오름차순
        test = ReverseArray.reverse(test); // 내림차순

        for(int i:test){
            if(i != heap.peek()) System.out.print("다르다!! >> ");
            System.out.println(i + " = " + heap.output());
        }

    }



}









