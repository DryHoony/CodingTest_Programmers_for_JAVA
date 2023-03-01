package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymClothes { // 체육복(탐욕법)


    public static void main(String[] args) {
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
