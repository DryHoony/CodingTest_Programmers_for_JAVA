import programmers.highScoreKit.Heap.MInHeapClass;

public class Test {


    public static void main(String[] args) {

        MInHeapClass heap = new MInHeapClass();

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
        while (!heap.isEmpty()){
            System.out.println("최댓값 출력:" + heap.output() + ", 남은 " + heap.toString());
        }








    }


}









