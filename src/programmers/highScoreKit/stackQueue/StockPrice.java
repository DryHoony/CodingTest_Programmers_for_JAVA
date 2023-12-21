package programmers.highScoreKit.stackQueue;

import java.util.*;

public class StockPrice {

    // ver1 - 정확성테스트 ok, 효율성테스트 fail! >> 2/5
    public static void main1(String[] args) {

        int[] price = {1,2,3,2,3}; // 4,3,1,1,0
        // 값은 1~10,000  길이는 2~100,000
        // 더 작은 숫자가 나올때 까지의 길이(거리) 기록

        // 연산용 변수
        int l = price.length; // 길이
        int[] answer = new int[l]; // 답
        int calIndex = 0; // 현재 위치, 탐색 위치

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> deleteKeyList = new ArrayList<>();

        for (int x : price){
            // 1. x값 map.keySet() 순회 연산 - x값이 더 작으면 answer 에 할당
            //반복문 중 삭제 변경시 ConcurrentModificationException 발생 >> 삭제연산을 분리

            System.out.println(calIndex + "번째에 해당하는 " + x + "연산");

            for (int key:map.keySet()){
                System.out.println("key = " + key);
                if(x < key){
                    for(int i:map.get(key)){
                        answer[i] = calIndex - i; // asnwer 할당
                    }
                    deleteKeyList.add(key); // 제거 할 key ListUp
                }
                // Set에서 순서 보장이 안되나? 답이 달라진다(틀림)
//                else break; // keySet 을 모두 조회할 필요없다.
            }
            // map 에서 key 제거
            for(int key:deleteKeyList){
                map.remove(key);
            }
            deleteKeyList.clear();

            // 2. x값 map 추가 연산 - 존재/비존재 구분
            if(map.containsKey(x)){
                // 존재하면 - value 값 List 에 추가
                map.get(x).add(calIndex);
            }
            else {
                // 존재하지 않으면 - key 로 추가
                map.put(x, new ArrayList<>());
                map.get(x).add(calIndex);
            }
            calIndex ++; // 다음 index
        }

        // 마무리 연산 - 남아있는 key,value 에 대해 answer 값 할당 연산
        calIndex--;
        for (int key:map.keySet()){
            for (int i:map.get(key)){
                answer[i] = calIndex-i;
            }
        }


//        System.out.println("map 출력확인"); // ok
//        for(int key:map.keySet()){
//            System.out.println("key = " + key);
//            System.out.println(map.get(key));
//        }

        System.out.println();
        System.out.println("답은 = ");
        for (int a:answer){
            System.out.println(a);
        }
    }

    // ver2 - Map 에서 KeySet 대신 별도의 TreeSet 구성, ver1 과 결과차이 없음
    public static void main2(String[] args) {
        int[] prices = {1,2,3,2,3};

        // 연산용 변수
        int l = prices.length;
        int[] answer = new int[l];
        int calIndex = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
//        Set<Integer> keySet = new TreeSet<>(); // 순서보장, keySet 대신 사용
        Set<Integer> keySet = new TreeSet<>(Collections.reverseOrder());
        List<Integer> deleteKeyList = new ArrayList<>();

        // 연산
        for (int x:prices){
//            System.out.println(x + "에 대한 조회, 현재 keySet = " + keySet);

            // 1. (x에 대해) 저장된 key 조회 연산
            for (int key:keySet){
//                System.out.println("x = " + x);
//                System.out.println("key = " + key);
                if(x < key){
//                    System.out.println("성공");
                    // 1.1 key 연산 - answer 할당, deleteKeyList 추가
                    for (int i:map.get(key)){
                        answer[i] = calIndex - i;
                    }
                    deleteKeyList.add(key);
                }
                else break;
            }
            // 1.3 deleteKeyList 연산 - map, KeySet 에서 제거
            for (int key:deleteKeyList){
                map.remove(key);
                keySet.remove(key);
            }
            deleteKeyList.clear();

            // 2. x를 map 추가 연산
            if(map.containsKey(x)){
                map.get(x).add(calIndex);
            }else {
                map.put(x, new ArrayList<>());
                map.get(x).add(calIndex);
                keySet.add(x);
            }

            calIndex++;
        }

        // 순회완료후 할당연산
        calIndex--;
        for (int key:keySet){
            for (int i:map.get(key)){
                answer[i] = calIndex-i;
            }
        }


        System.out.println();
        System.out.println("답은 = ");
        for (int a:answer){
            System.out.println(a);
        }
    }

    // ver3 - 정의 그대로 연산, Brute 하게
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3}; // 4,3,1,1,0

        // 연산용 변수
        int l = prices.length;
        int[] answer = new int[l];
        int x;
        boolean isAnswered = false;

        for (int i = 0; i < l; i++) {
            x = prices[i];
            System.out.println(i + " Index 에서 " + x + " 값 연산 ----------");
            System.out.println("isAnswered = " + isAnswered);
            // x보다 작은 가격 나올때 까지 탐색
            for (int j = i+1; j < l; j++) {
                if(prices[j] < x){
                    System.out.println("범위 연산 >> "+(j-i));
                    answer[i] = j-i;
                    isAnswered = true; // 범위내 탐색 ok
                    break;
                }
            }

            if (!isAnswered){ // 범위내 탐색 no case 할당
                System.out.println("바깥 연산 >> " + (l-i-1));
                answer[i] = l-i-1;
            }

            isAnswered = false;


//            System.out.println(answer[i]);
        }

//        System.out.println("답은 = ");
    }

}
