import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        int[] list1;
        int[] list2;

        list1 = new int[]{1, 2, 3, 4};
        list2 = new int[]{10, 20, 30, 40,50,60,70};

//        list1 = list2; // 얕은복사!! >> 곤란
        list1 = list2.clone(); // 깊은복사

        for (int i:list1){
            System.out.println(i);
        }

        for (int i = 0; i < list1.length; i++) {
            list1[i] = 0;
        }

        System.out.println();
        System.out.println("list1 0변경 출력확인");
        for (int i:list1){
            System.out.println(i);
        }

        System.out.println();
        System.out.println("list2 가 따라서 변경되는지 출력확인");
        for(int i:list2){
            System.out.println(i);
        }



    }


}
