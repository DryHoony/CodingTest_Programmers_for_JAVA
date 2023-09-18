package programmers.level2;

import java.util.*;

public class SeesawMate { // 시소짝궁
    static int min;
    static int max;

    public static ArrayList<Integer> canMate(int w){
        ArrayList<Integer> mate = new ArrayList<>();
        // 2w / (2,3,4)
//        mate.add(w);
//        if(w%3==0) mate.add(2*w/3);
//        if(w%2==0) mate.add(w/2);

        // 3w / (2,3,4)
//        if(w%2==0) mate.add(3*w/2);
//        if(w%4==0) mate.add(3*w/4);

        // 4w / (2,3,4)
//        mate.add(2*w);
//        if(w%3==0) mate.add(4*w/3);

        // 재구성
        mate.add(w);
        if(2*w<=max) mate.add(2*w);
        if(w%2==0){
            if(min<=w/2) mate.add(w/2);
            if(3*w/2<=max) mate.add(3*w/2);
        }
        if(w%3==0){
            if(min<=2*w/3) mate.add(2*w/3);
            if(4*w/3<=max) mate.add(4*w/3);
        }
        if(w%4==0 && min<=3*w/4) mate.add(3*w/4);

        Collections.sort(mate);

        return mate;
    }


    public static void main0(String[] args) { // 성공!
        int[] weights = {100,180,360,100,270}; // 숫자중복 존재 가능, 쌍의 원소 중복 가능
        // 길이 2~100000, 값100~1000

        Arrays.sort(weights);
        min = weights[0];
        max = weights[weights.length-1];


//        for(int w:weights){
//            System.out.println(w+"의 mate 집합");
//            System.out.println(canMate(w));
//        }

        long count = 0L; // 답이 Long 타입이다!!!
        Map<Integer, Long> map = new HashMap<>(); // <weight, count>

        // 본 연산
        for(int weight:weights){

            if(map.containsKey(weight)){
                count += map.get(weight);
            }

            for(int w:canMate(weight)){
                if(map.containsKey(w)){
                    map.put(w, map.get(w)+1);
                }
                else map.put(w,1L);
            }
        }



        System.out.println("답은 >> "+count);
    }


    public static void main(String[] args) { // 다른 풀이 - 시간 굉장히 짧다!!
        // Point!! - weights 는 확정정으로 한번만 스캔하면 되고
        // 길이 1000 비교적 짧은 arr 만 연산하면 된다.

        int[] weights = {100,180,360,100,270}; // 숫자중복 존재 가능, 쌍의 원소 중복 가능
        // 길이 2~100000, 값100~1000

        long answer = 0;
        long[] arr = new long[1001]; // 몸무게를 index 값으로 세팅 - 101~1000

        // 몸무게 인원수 할당 - 증가하는 연산만 count++ (중복방지)
        for(int i = 0; i < weights.length; i++){
            arr[weights[i]]++;
        }

        for(int i = 100; i < 1001; i++){
            if(arr[i] == 0) continue;
            answer += (arr[i] * (arr[i] - 1)) / 2;


            if((4 * i) / 3 > 1000) continue;
            if(i % 3 == 0){
                answer += arr[i] * arr[(4 * i) / 3];
            }

            if((3 * i) / 2 > 1000) continue;
            if(i % 2 == 0){
                answer += arr[i] * arr[(3 * i) / 2];
            }

            if(2 * i >1000) continue;
            answer += arr[i] * arr[2 * i];
        }


    }

}
