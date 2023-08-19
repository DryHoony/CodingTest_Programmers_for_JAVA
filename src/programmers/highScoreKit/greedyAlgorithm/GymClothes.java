package programmers.highScoreKit.greedyAlgorithm;

import java.util.*;

public class GymClothes { // 체육복(탐욕법)

    public static void main(String[] args) {
        // 그리디 알고리즘 try
        // input
        int n = 5; // 2~30
        int[] lost = {2,4}; // 1~n
        int[] reserve = {1,3,5};

        // 연산을 위한 변수 - 초기값은 false
        boolean[] lostFlagArray = new boolean[n]; // ture - 체육복 없음
        boolean[] reserveFlagArray = new boolean[n]; // true - 여유복 있음
        int answer = 0; // 체육복 있음 or 빌림

        for(int i:lost){
            lostFlagArray[i-1] = true;
        }
        for(int i:reserve){
            reserveFlagArray[i-1] = true;
        }

        // "내 체육복 연산 - 빌려주는 연산" 두단계 구분하지 말고 한번에 try
        // 단, 좌우 연산때문에 첫번째와 마지막 연산은 반복문 밖에서 따로 시행
        // 오른쪽으로 진행하므로, 오른쪽 빌리기 전에 if(오른쪽 애는 잃어버리진 않았나) 확인

        if(lostFlagArray[0]){ // 첫번째 연산
            if(reserveFlagArray[0]){
                reserveFlagArray[0] = false;
                answer++;
            } else if (reserveFlagArray[1] && !lostFlagArray[1]) {
                reserveFlagArray[1] = false;
                answer++;
            }
        }else answer++;

        for (int i = 1; i < n-1; i++) { // 중간연산
            if(lostFlagArray[i]){ // 체육복 없으면

                if(reserveFlagArray[i]){ // 내꺼 여유분
                    reserveFlagArray[i] = false;
                    System.out.println(i+"는 빌렸다");
                    answer ++;
                } else if (reserveFlagArray[i-1]) { // 왼쪽 여유분
                    reserveFlagArray[i-1] = false;
                    System.out.println(i+"는 빌렸다");
                    answer ++;
                } else if (reserveFlagArray[i+1] && !lostFlagArray[i+1]) { // 오른쪽 여유분 - 오른쪽애는 잃어버리지 않아야 빌릴 수 있다.
                    reserveFlagArray[i+1] = false;
                    System.out.println(i+"는 빌렸다");
                    answer ++;
                }

            }else{ // 체육복 있으면 그냥 참가
                System.out.println(i+"는 체육복 있다");
                answer ++;
            }
        }

        if(lostFlagArray[n-1]){ // 마지막 연산
            if(reserveFlagArray[n-1]){
                reserveFlagArray[n-1] = false;
                answer++;
            } else if (reserveFlagArray[n-2]) {
                reserveFlagArray[n-2] = false;
                answer++;
            }
        } else answer++;

        System.out.println(answer);
    }

    public static void main0(String[] args) {
        int[] lost = {2,4};
        int[] reserve = {3};
        int n = 5; // 해결되지 않은 lost 만큼 빼서 답으로 return

        // 정렬X -> 테스트13,14 실패, 문제조건을 의심해보자!
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> l = new ArrayList<Integer>();
        List<Integer> r = new ArrayList<Integer>();
        for(int i:lost){
            l.add(i);
        }
        for(int i:reserve){
            r.add(i);
        }

        // 본인꺼 겹칩 제거
        List<Integer> self = new ArrayList<Integer>();
        for(int i:l){
            if(r.contains(i)) self.add(i);
        }
        for(int i:self){
            l.remove(l.indexOf(i));
            r.remove(r.indexOf(i));
        }

        // 오른쪽으로 연산
        for(int i:l){
            if(r.indexOf(i-1) != -1){ // i-1포함하면
                r.remove(r.indexOf(i-1));
            } else if (r.indexOf(i+1) != -1) { // i+1 포함하면
                r.remove(r.indexOf(i+1));
            }else {
                n--;
            }

        }


        System.out.println(n); // 정답 return 값



    }

}
