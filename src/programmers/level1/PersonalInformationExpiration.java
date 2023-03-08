package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInformationExpiration { // 개인정보 유효기간

    // today 기준 날자계산
    public static int dayCount(String today, String privacy){

        return 0;
    }

    public static void main(String[] args) {
        // 2000 ≤ YYYY ≤ 2022  01 ≤ MM ≤ 12  01 ≤ DD ≤ 28
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        List<Integer> result = new ArrayList<>(); // 몇개가 될지 모름 >> 추후 int[]로 변경
        Map<String,Integer> term = new HashMap<>(); // 타입확인 >> 필요시 변경

        for (int i = 0; i < terms.length; i++) {
            term.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }

        int month;
        for (int i = 0; i < privacies.length; i++) {
//            privacies[i] // 파기할 정보인지 확인
            month = (Integer.parseInt(today.substring(2,4)) - Integer.parseInt(privacies[i].substring(2,4)))*12 +
                    Integer.parseInt(today.substring(5,7)) - Integer.parseInt(privacies[i].substring(5,7));

            if(month > term.get(privacies[i].substring(11))){
                //파기
                result.add(i+1);
                System.out.println(i+1); // 확인용
            } else if (month == term.get(privacies[i].substring(11))) {
                if(Integer.parseInt(today.substring(8,10)) - Integer.parseInt(privacies[i].substring(8,10)) >= 0){
                    // 파기
                    result.add(i+1);
                    System.out.println(i+1); // 확인용
                }
            }
        }

        // 결과 return

    }
}
