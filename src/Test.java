import java.util.*;

public class Test {

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


    public static void main(String[] args) { // 명예의 전당 ArrayList이용
        int k = 3;
        int[] score = {10,100,20,150,1,100,200};

        int l = score.length;
        int[] answer = new int[l];
        List<Integer> hallOfFame = new ArrayList<>(); // 명예의 전당
        hallOfFame.add(-1);

        for (int i = 0; i < l; i++) {
            // 명예의 전당 심사 >> 추가-정렬-꼴찌제거(3명 이상일때만)
            hallOfFame.add(score[i]);
            Collections.sort(hallOfFame);
            hallOfFame.remove(0);

            // 최하위 출력 - answer에 할당
            answer[i] = hallOfFame.get(0);
            System.out.println(hallOfFame.get(0)); // 확인용
        }


        System.out.println(answer);
    }


    }





