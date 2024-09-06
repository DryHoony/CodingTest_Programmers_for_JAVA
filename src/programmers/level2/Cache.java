package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache { // 캐시 (2018 카카오 블라인드)

    // 도시이름 검색 -> 맛집 게시물 출력
    // 입력된 도시이름 배열을 순서대로 처리할때, 총 실행시간 출력

    // 캐시 교체 알고리즘 LRU(Least Recently Used) 사용 (가장 오랫동안 참조되지 않은 페이지를 교체)
    // cache hit -> 실행시간 1
    // cache miss -> 실행시간 5

    public static void main(String[] args) {
        int cacheSize; // 0~30
        String[] cities; // 1~100,000
        int answer; // 총 실행시간

        // 예시1
        cacheSize = 3;
        cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        answer = 50;

        // 예시5, 대소문자 구분X
        cacheSize = 2;
        cities = new String[]{"Jeju", "Pangyo", "NewYork", "newyork"};


        System.out.println(solution(cacheSize,cities));
    }

    // Queue 이용 - Queue의 중간위치 값을 제거 할 수 없으니, Queue를 두개 운용 -> Q1조회 -> Q2할당
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> q1 = new LinkedList<>(); // 이전
        Queue<String> q2 = new LinkedList<>(); // 현재 연산

        for(String city : cities){
            // q1 을 q2에 할당하면서 city 가 있을때, answer += 1
            // q1 을 q2에 할당하면서 city 가 없을때, answer += 5, q2의 크기가 cacheSize 보다 크면 poll
            q2 = new LinkedList<>(); // 초기화
            String str;
            String dupCity = "";

            answer += 5;
            while(!q1.isEmpty()){
                str = q1.poll();
                if(str.equals(city.toLowerCase())){
                    answer -= 4;
                    dupCity = str;
                }
                else q2.add(str);
            }
            if(dupCity.isEmpty()){
                q2.add(city.toLowerCase());
            }else q2.add(dupCity);

            if(q2.size() > cacheSize) q2.remove();

            q1 = q2; // 다음연산 준비
        }





        return answer;
    }
}
