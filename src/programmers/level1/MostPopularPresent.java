package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class MostPopularPresent { // 2024 카카오 winter internship
    // 많이 준 사람이 받는다
    // (동률일 경우) 선물 지수가 큰 사람이 받는다. (지수 : 준것 - 받은것)
    // 선물 지수가 같다면 주고받지 않는다.
    // return '선물을 가장 많이 받을 친구'가 받을 '선물의 수'

    public static void main(String[] args) {
        String[] friends; // 값~10 (중복X, 알파벳 소문자), 길이 2~50
        String[] gifts; // 길이 1~10000
        int result;

        // 입력 1
//        friends = new String[]{"muzi", "ryan", "frodo", "neo"};
//        gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//        result = 2;

        // 입력 2
//        friends = new String[]{"joy", "brad", "alessandro", "conan", "david"};
//        gifts = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
//        result = 4;

        // 입력 3
        friends = new String[]{"a", "b", "c"};
        gifts = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        result = 0;

        // 솔루션 테스트
        int answer =  solution(friends, gifts);
        System.out.println(answer);

    }

    public static int solution(String[] friends, String[] gifts){
        // 연산용 변수
        int l = friends.length;
        Map<String, Integer> nameIndexMap = new HashMap<>(); // 이름 대신 사용할 Index 변환
        for (int i = 0; i < l; i++) {
            nameIndexMap.put(friends[i],i);
        }

        int[][] giftMatrix = new int[l][l]; // [i][j] 는 i->j 선물 준 갯수
        int[] giftCounts = new int[l];
        int giftCount;
        int[] giftReceivePredict = new int[l];

        String[] giftWho;
        int max = 0;

        // '행렬'로 주고받은 서로서로 주고 받은 선물의 수 구하기 >> giftMatrix
        for (String gift:gifts){
            giftWho = gift.split(" ");

//            System.out.print(giftWho[0] +" -> ");
//            System.out.println(giftWho[1]);

            giftMatrix[nameIndexMap.get(giftWho[0])][nameIndexMap.get(giftWho[1])]++;
        }

        // 각 인원의 선물지수 구하기 >> giftCount
        // i의 선물지수 = 준것 - 받은것 = sum_x(giftMatrix[i][x]) - sum_y(giftMatrix[y][i])
        for (int i = 0; i < l; i++) {
            giftCount = 0; // 초기화
            for (int j = 0; j < l; j++) {
                giftCount += giftMatrix[i][j];
                giftCount -= giftMatrix[j][i];
            }

            giftCounts[i] = giftCount; // 할당
        }

        // '행렬'에서 관계간에 선물연산 (서로 주고받은 갯수, 선물지수) >> giftReceivePredict
        for (int i = 0; i < l-1; i++) {
            for (int j = i+1; j < l; j++) {
                // i기준 j에게 주는지 받는지 비교 연산 >> giftReceivePredict[i]
                if(giftMatrix[i][j] > giftMatrix[j][i]){
                    giftReceivePredict[i] ++;
                }else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    giftReceivePredict[j] ++;
                }else { // ==, 선물지수 비교
                    if(giftCounts[i] > giftCounts[j]){
                        giftReceivePredict[i] ++;
                    } else if (giftCounts[i] < giftCounts[j]) {
                        giftReceivePredict[j] ++;
                    }else {
                        continue;
                    }
                }

            }
        }

        // 답 : giftReceivePredict 에서 가장 높은 값 >> max
        for (int k:giftReceivePredict){
            if(k > max) max = k;
        }

        return max;
    }



}
