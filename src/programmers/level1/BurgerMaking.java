package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class BurgerMaking { // 햄버거 만들기


//    public static void main(String[] args) {
//        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//
//        List<Integer> burger = new ArrayList<>();
//        int answer = 0; // "1231 출력 갯수"
//
//        for (int n:ingredient){
//            burger.add(0,n);
//            // 햄버거 연산 1231 >> 뒤집힌 1321 찾기
//            if(n==1 && burger.size()>=4){
//                if(burger.get(1)==3 && burger.get(2)==2 && burger.get(3)==1){
//                    burger = burger.subList(4, burger.size());
//                    answer++;
//                }
//                // 추가연산
//                while(burger.size()>=4){
//                    if(burger.get(0)==1 && burger.get(1)==3 && burger.get(2)==2 && burger.get(3)==1){
//                        burger = burger.subList(4, burger.size());
//                        answer++;
//                    }else{
//                        break;
//                    }
//                }
//            }
//        }
//
//        //결과
//        System.out.println(answer);
//
//
//    } // 시간초과(4~8, 12)

    public static int made(String burger){
        int count=0;
        // 1이 새롭게 쌓이지 않으면 무쓸모 >> 버리자!
        burger = burger.substring(0,burger.lastIndexOf("1")+1);

        while(burger.contains("1231")){
            burger = burger.replaceFirst("1231","");
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1,2,3,1,1,2,1,2,3,2,3,1,2,3,1,2,1,3,2,1,3};
        int answer = 0; // "1231 출력 갯수"

        String burger = "";
        for(int n:ingredient){
            burger += n;
        }

        // 연산
        burger = burger.substring(0,burger.lastIndexOf("1")+1); // 1이 새롭게 쌓이지 않으면 무쓸모 >> 버리자!
        while(burger.contains("1231")){
            burger = burger.replaceFirst("1231","");
            answer++;
        }




        //결과
        System.out.println(answer);

    }

}
