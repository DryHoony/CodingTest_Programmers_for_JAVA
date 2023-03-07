package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HallOfFame {

    // 명예의 전당 심사, 업데이트
    public static int[] FameUpdate(int[] list, int a){
        // 추가-정렬-꼴지제거
        int[] list2 = new int[list.length];
        list2[0] = a;
        for (int i = 1; i < list2.length; i++) {
            list2[i] = list[i];
        }

        Arrays.sort(list2);

        return Arrays.copyOfRange(list2,1,list2.length);
    }

    // 정렬된 ArrayList 에 추가-정렬-삭제 연산 (size는 유지)
    public static ArrayList<Integer> listUpdate(ArrayList<Integer> list, int a){
        // 해당X
        if(a <= list.get(0)) return list;

        int i =1;
        while(i<list.size()){
            if(a>list.get(i)) break;
            i++;
        }
        // a는 [i-1]에 위치



        ArrayList<Integer> answer = new ArrayList<>();
        //앞자리
        for (int j = 0; j < i - 1; j++) {
            answer.add(list.get(j));
        }
        answer.add(a);
        //뒷자리
        for (int j = i; j < list.size(); j++) {
            answer.add(list.get(j));
        }

        return answer;
    }



//    public static void main(String[] args) { // 뭐가 잘못 됬지?,,
//        int k = 3;
//        int[] score = {10,100,20,150,1,100,200};
//
//        int l = score.length;
//        int[] answer = new int[l];
//        int[] hallOfFame = new int[k]; // 명예의 전당
//        for (int i = 0; i < k; i++) {
//            hallOfFame[i] = -1; //초기화
//        }
//
//
//        for (int i = 0; i < l; i++) {
//            // 명예의 전당 심사, 업데이트
//            hallOfFame = FameUpdate(hallOfFame, score[i]);
//            // 명예의 전당 최하위 출력 - answer에 할당
//            for (int n:hallOfFame){
//                if (n!=-1){
//                    answer[i] = n;
//                    System.out.println(n); // 확인용
//                }
//            }
//        }
//
//        System.out.println(answer);
//
//
//    }


    public static void main(String[] args) { // 명예의 전당 ArrayList이용, 런타임 에러
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        int l = score.length;
        int[] answer = new int[l];
        ArrayList<Integer> hallOfFame = new ArrayList<>(); // 명예의 전당

        // k명 까지
        for (int i = 0; i < k; i++) {
            hallOfFame.add(score[i]);
            Collections.sort(hallOfFame);

            answer[i] = hallOfFame.get(0);
            System.out.println(answer[i]); // 확인용
        }

        // k명 이후
        for (int i = k; i < l; i++) {
            if (score[i] > hallOfFame.get(0)){
                hallOfFame.add(score[i]);
                Collections.sort(hallOfFame);
                hallOfFame.remove(0);

                // 정렬된 ArrayList에 추가-정렬-삭제
//                hallOfFame = listUpdate(hallOfFame, score[i]); // 오류있다.
            }

            answer[i] = hallOfFame.get(0);
            System.out.println(answer[i]); // 확인용
        }

        System.out.println(answer);
    }
}
