import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class Test {


    public static void main(String[] args) {
        Set<Integer> set;
//        set = new HashSet<>(); // [80, 50, 100, 20, 70, 40, 90, 10, 60, 30]
//        set = new LinkedHashSet<>(); // [100, 90, 80, 70, 60, 50, 40, 30, 20, 10]

//        set = new TreeSet<>(); // [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
        set = new ConcurrentSkipListSet<>(); // [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

        for (int i=10; i>0; i--){
            set.add(i*10);
        }

        System.out.println(set);
    }


    public static void main0(String[] args) {

        int[] prices = {1,2,3,2,3}; // 4,3,1,1,0
        // 값은 1~10,000  길이는 2~100,000
        // 더 작은 숫자가 나올때 까지의 길이(거리) 기록

        // 연산용 변수
        int l = prices.length; // 길이
        int[] answer = new int[l]; // 답
        int calIndex = 0; // 현재 위치, 탐색 위치

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> deleteKeyList = new ArrayList<>();

        for (int x : prices){
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


    // '프로그래머스' 에서는 array가 []로 주어진다.
    // [] 를 {} 로 바꿔서 입력하자
    public static String bracketTranslate(String input){
        input = input.replaceAll("\\[","{");
        input = input.replaceAll("\\]","}");

        System.out.println(input);
        return input;
    }

    public static String bracketTranslateReverse(String input){
        input = input.replaceAll("\\{","\\[");
        input = input.replaceAll("}","]");

        System.out.println(input);
        return input;
    }
}









