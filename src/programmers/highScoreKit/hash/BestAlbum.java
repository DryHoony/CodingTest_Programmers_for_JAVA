package programmers.highScoreKit.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum { // 베스트앨범

    public static void main(String[] args) {
//        장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시 (장르에 속한 곡이 하나라면, 하나의 곡만 선택)
//        1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. (모든 장르는 재생된 횟수가 다름)
//        2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//        3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. answer 에 추가

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int l = genres.length;

        // 1. 연산 - play 순서로 genre 고르기
        Map<String,Integer> genrePlayTime = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if(genrePlayTime.containsKey(genres[i]))
                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
            else
                genrePlayTime.put(genres[i], plays[i]);
        }


        // gerePlayTime 에서 value(plays) 높은 순서로 key(genre)출력 - 2.로 연결
        System.out.println(genrePlayTime.keySet());
        System.out.println(genrePlayTime.values());


        // 2. 출력된 key(genre)에 해당하는 노래(index)중 play 횟수가 1,2위인 노래(index)만 출력 - 3.으로 연결



        // 3. 출력된 노래(index)를 answer 에 추가
        List<Integer> answer = new ArrayList<>();

    }

}
