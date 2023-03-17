import programmers.highScoreKit.Heap.MInHeapClass;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] test = {2,5,6,78,4,2,6,4,4,2,5,5,9,7,26,416,5,498,746,24,9,7,5,4,9,11,1,3,3,4,4,879,5};

        MInHeapClass minheap = new MInHeapClass();

        for (int i:test){
            minheap.input(i);
        }

        Arrays.sort(test);

        for(int i:test){
            if(i != minheap.peek()) System.out.print("다르다!! >> ");
            System.out.println(i + " = " + minheap.output());
        }

    }



}









