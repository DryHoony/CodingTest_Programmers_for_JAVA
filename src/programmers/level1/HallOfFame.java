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


//    public static void main(String[] args) { // 명예의 전당 ArrayList이용, 런타임 에러
//        int k = 4;
//        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
//
//        int l = score.length;
//        int[] answer = new int[l];
//        ArrayList<Integer> hallOfFame = new ArrayList<>(); // 명예의 전당
//
//        // k명 까지
//        for (int i = 0; i < k; i++) {
//            hallOfFame.add(score[i]);
//            Collections.sort(hallOfFame);
//
//            answer[i] = hallOfFame.get(0);
//            System.out.println(answer[i]); // 확인용
//        }
//
//        // k명 이후
//        for (int i = k; i < l; i++) {
//            if (score[i] > hallOfFame.get(0)){
//                hallOfFame.add(score[i]);
//                Collections.sort(hallOfFame);
//                hallOfFame.remove(0);
//
//                // 정렬된 ArrayList에 추가-정렬-삭제
////                hallOfFame = listUpdate(hallOfFame, score[i]); // 오류있다.
//            }
//
//            answer[i] = hallOfFame.get(0);
//            System.out.println(answer[i]); // 확인용
//        }
//
//        System.out.println(answer);
//    }

    public static void rankAdd(List<Integer> rank, int n){
        // 정렬된 array 에 값 추가
        for (int i = 0; i < rank.size(); i++) {
            if(n <= rank.get(i)){
                rank.add(i, n); // i 위치에 n을 삽입
//                break;
                return; // 메소드 종료?
            }
        }

        // 최대값 일때
        rank.add(n);
    }

    // ver3 - k가 score.length 보다 클때 - 런타임에러 9,11 의심 >> 보완
    public static void main(String[] args) {
        int k = 3; // 상위 k번째 >> 명예의 전당, 3~100
        int[] score = {10,100,20,150,1,100,200}; // Daily 점수 / 갯수:7~1,000 / 값 0~2,000

//        int k = 4;
//        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        int[] answer= new int[score.length];
        List<Integer> rank = new ArrayList<>();

        // k 번째 까지
        if(k >= score.length){ // ver3 수정 파트
            for (int i = 0; i < score.length; i++) {
                rankAdd(rank, score[i]);
                answer[i] = rank.get(0);
            }
        }else {
            for (int i = 0; i < k; i++) {
                rankAdd(rank, score[i]);
                answer[i] = rank.get(0);
            }
        }

        // k 번째 이후
        for (int i = k; i < score.length; i++) {
            if(rank.get(0) < score[i]){
                // 전당등록
                rank.remove(0); // rank 에서 최소값 삭제
                rankAdd(rank, score[i]); // 등록 - 정렬유지
            }

            // rank 업데이트 유무에 상관없이 answer값 등록
            answer[i] = rank.get(0);
        }

        // 출력
        for (int a:answer){
            System.out.println(a);
        }
    }


}
