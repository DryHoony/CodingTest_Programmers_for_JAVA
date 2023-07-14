package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class MemoryScore { // 추억점수


    public static void main(String[] args) {
        // input
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = new int[photo.length];
        Map<String, Integer> nameScore = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            nameScore.put(name[i], yearning[i]);
        }

        String[] photoShot;
        for (int i = 0; i < photo.length; i++) {
            photoShot = photo[i];

            for(String photoName:photoShot){
//                System.out.println(photoName); // 확인
                if(nameScore.get(photoName) != null){
                    answer[i] += nameScore.get(photoName); // 없는값을 출력했을 때?
                }
            }
            System.out.println(answer[i]); // 확인용 출력 - 정답
        }


//        return answer;


    }



}
