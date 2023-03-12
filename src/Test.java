import java.util.*;

public class Test {

    // Map<,> 이용 ver - 주어진 값을 key 로 해당 index 를 value 에 담는다
    // 중복은 처리못함 - key 값이 겹치기에 중복 처리 X
    public static int[] rankArrange(int[] list){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (!map.containsKey(list[i]))
                map.put(list[i],i);
        }

        Integer[] keyList = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keyList); // 오름차순
        keyList = reverseIntArray(keyList); // 내림차순

        int[] answer = new int[list.length];
        // list 의 원소의 등수(큰 순서)에 해당하는 index 할당
        int i=1;
        for (int n:keyList){
            answer[map.get(n)] = i; // key 값에 해당하는 원소는 i등
            i++;
        }

        return answer;
    }

    public static Integer[] reverseIntArray(Integer[] list){
        int l = list.length;
        Integer[] answer = new Integer[l];

        for (int i = 0; i < l; i++) {
            answer[i] = list[l-1-i];
        }

        return answer;
    }


    public static void main(String[] args) {
//        int[] array = {9,3,4,1,7,6,2,8,5};
//        int[] rank = rankArrange(array); // ok 잘 작동
//        for (int i:rank){
//            System.out.println(i);
//        }





    }

    //    public static void main(String[] args) { // ver1 - 엉망진창 실패
////        장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시 (장르에 속한 곡이 하나라면, 하나의 곡만 선택)
////        1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. (모든 장르는 재생된 횟수가 다름)
////        2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
////        3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. answer 에 추가
//
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        int l = genres.length;
//
//        // 1. 연산 - play 순서로 genre 고르기
//        Map<String,Integer> genrePlayTime = new HashMap<>();
//        for (int i = 0; i < l; i++) {
//            if(genrePlayTime.containsKey(genres[i]))
//                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
//            else
//                genrePlayTime.put(genres[i], plays[i]);
//        }
//
//        // gerePlayTime 에서 value(plays) 높은 순서로 key(genre)출력 - 2.로 연결
//        System.out.println(genrePlayTime.keySet());
//        System.out.println(genrePlayTime.values());
//
////        Integer[] test2 = genrePlayTime.values().toArray(new Integer[0]);
//        int[] genreRank = rankArrange(genrePlayTime.values().toArray(new Integer[0]));
//        String[] genreList = genrePlayTime.keySet().toArray(new String[0]);
////        for (int i:genreRank){
////            System.out.println(i);
////        }
//
//
//        // 2. 출력된 key(genre)에 해당하는 노래(index)중 play 횟수가 1,2위인 노래(index)만 출력 - 3.으로 연결
//        // 3. 출력된 노래(index)를 answer 에 추가
//        List<Integer> answer = new ArrayList<>();
//        int a,b,ai,bi;
//
////        for(int i:genreRank){
////            String genre = genreList[i-1];
////        }
//
//        for (int k:genreRank){ // keySet의 array가 빠졌다!!!
//            String genre = genreList[k-1];
//            a=0; // max PlayTime
//            b=0; // second
//            ai=0; // max PlayTime Index
//            bi=0;
//
//            for (int i = 0; i < l; i++) {
//                if(genres[i].equals(genre)){
//                    // 해당 장르이면 top1,2 찾기 연산
//                    if(plays[i]>a){
//                        b = a;
//                        a = plays[i];
//                        bi = ai;
//                        ai = i;
//                    } else if (plays[i]>b) {
//                        b = plays[i];
//                        bi = i;
//                    }
//                }
//            }
//
//            answer.add(ai);
//            answer.add(bi);
//        }
//
//        // 출력 확인
//        System.out.println(answer);
//
//    }

    }





