package programmers.highScoreKit.hash;

import java.util.*;

public class BestAlbum { // 베스트앨범

    // Map<,> 이용 ver - 주어진 값을 key 로 해당 index 를 value 에 담는다
    // 중복은 처리못함 - key 값이 겹치기에 중복 처리 X
    public static int[] rankArrange(Integer[] list){
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


//    public static void main(String[] args) { // ver2
////        장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시 (장르에 속한 곡이 하나라면, 하나의 곡만 선택)
////        1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다. (모든 장르는 재생된 횟수가 다름)
////        2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
////        3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. answer 에 추가
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//
//        int l = genres.length;
//
//        // 장르별 데이터 구분
//        Map<String,Map<Integer,Integer>> genreDetail = new HashMap<>(); // 해당장르의 Map<plays, Index>를 가진다.
//        Map<String,Integer> genrePlayTime = new HashMap<>(); // 해당장르의 총 playTime
//
//        for (int i = 0; i < l; i++) {
//
//            if (genreDetail.containsKey(genres[i])){ // 해당장르 있으면 추가
//                genreDetail.get(genres[i]).put(plays[i],i);
//            }else{ // 해당장르 없으면 새롭게 할당
//                Map<Integer,Integer> newMap = new HashMap<>(); // 장르마다 새로 생성하면 새로운 객체?(다른 참조값?)
//                newMap.put(plays[i],i);
//                genreDetail.put(genres[i], newMap); // 같은값을 참조하여, 중복되기 싶다!! 추후 자세히 검토 필요!
////                newMap.clear();
//            }
//
//            if (genrePlayTime.containsKey(genres[i])){  // 해당장르 있으면 시간 추가
//                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
//            }else{ // 해당장르 없으면 시간 새롭게 할당
//                genrePlayTime.put(genres[i],plays[i]);
//            }
//        }
//        System.out.println("genreDetail = " + genreDetail); // ok
//        System.out.println("genrePlayTime = " + genrePlayTime);
//
//
//        // 1. 연산 - play 순서로 genre 고르기
////        Map<String,Integer> genrePlayTime = new HashMap<>();
//        List<String> genreRank = new ArrayList<>(); // 장르 순위 판별
//        int i;
//        for(String genre:genrePlayTime.keySet()){
//            i=0;
//            while (i<genreRank.size()){
//                if(genrePlayTime.get(genreRank.get(i)) > genrePlayTime.get(genre))
//                    i++;
//                else break;
//            }
//            genreRank.add(i,genre); // 로직 검증필요!
//        }
//
//        // 장르순위 확인 test
//        System.out.println("genreRank = " + genreRank);
//
//
//
////        2. 출력된 key(genre)에 해당하는 노래(index)중 play 횟수가 1,2위인 노래(index)만 출력 - 3.으로 연결
////        3. 출력된 노래(index)를 answer 에 추가
//        List<Integer> answer = new ArrayList<>();
//        int a,b,ai,bi;
//
//        for (String genre:genreRank){
//            // 해당 genre 에서 top1,2를 선정해(genreDetail 연산) answer 에 추가
//            Integer[] top12 = genreDetail.get(genre).keySet().toArray(new Integer[0]);
//            a=0;
//            b=0;
//            for (int n:top12){
//                if(n>a){
//                    b=a;
//                    a=n;
//                } else if (n>b) {
//                    b=n;
//                }
//            }
//
//            answer.add(genreDetail.get(genre).get(a));
//            answer.add(genreDetail.get(genre).get(b));
//        }
//
//
//        System.out.println(answer);
//
//
//    }

//    public static void main(String[] args) { // ver3 - 2,15실패! 많이했다!!
////        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
////        int[] plays = {500, 600, 150, 800, 2500};
//        String[] genres = {"classic", "pop", "classic", "classic"};
//        int[] plays = {500, 600, 150, 800};
//        // 장르내에 노래가 하나만 있을경우를 고려!!
//
//        int l = genres.length;
//
//        // 장르별 데이터 구분
//        Map<String,Map<Integer,Integer>> genreDetail = new HashMap<>(); // 해당장르의 Map<plays, Index>를 가진다.
//        Map<String,Integer> genrePlayTime = new HashMap<>(); // 해당장르의 총 playTime
//        for (int i = 0; i < l; i++) {
//
//            if (genreDetail.containsKey(genres[i])){ // 해당장르 있으면 추가
//                genreDetail.get(genres[i]).put(plays[i],i);
//            }else{ // 해당장르 없으면 새롭게 할당
//                Map<Integer,Integer> newMap = new HashMap<>(); // 장르마다 새로 생성하면 새로운 객체?(다른 참조값?)
//                newMap.put(plays[i],i);
//                genreDetail.put(genres[i], newMap); // 같은값을 참조하여, 중복되기 싶다!! 추후 자세히 검토 필요!
////                newMap.clear();
//            }
//
//            if (genrePlayTime.containsKey(genres[i])){  // 해당장르 있으면 시간 추가
//                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
//            }else{ // 해당장르 없으면 시간 새롭게 할당
//                genrePlayTime.put(genres[i],plays[i]);
//            }
//        }
//        System.out.println("genreDetail = " + genreDetail); // ok
//        System.out.println("genrePlayTime = " + genrePlayTime);
//
//        // 1. 속한노래가 많이 재생된 장르순서 뽑기(중복X)
//        List<String> genreRank = new ArrayList<>(); // 장르 순위 판별
//        int i;
//        for(String genre:genrePlayTime.keySet()){
//            i=0;
//            while (i<genreRank.size()){
//                if(genrePlayTime.get(genreRank.get(i)) > genrePlayTime.get(genre))
//                    i++;
//                else break;
//            }
//            genreRank.add(i,genre); // 로직 검증필요!
//        }
//
//        // 장르순위 확인 test
//        System.out.println("genreRank = " + genreRank);
//
//        // 2. 1.에서 뽑힌 장르순서로, 장르 내 많이 재생된 노래를 두 개 수록
//
//        List<Integer> answer = new ArrayList<>();
//        int a,b,ai,bi;
//
//        for(String genre:genreRank){
//            // 3. 2.에서 수록할 때, 장르 내 재생 횟수가 같으면(중복이면) 고유 번호가 낮은 노래 먼저, 장르에 곡이 하나라면 하나만 수록(예외처리)
//            Integer[] top12 = genreDetail.get(genre).keySet().toArray(new Integer[0]);
//            if(top12.length==1){
//                answer.add(genreDetail.get(genre).get(top12[0]));
//            }
//            else{
//                a=0;
//                b=0;
//                for (int n:top12){
//                    if(n>a){
//                        b=a;
//                        a=n;
//                    } else if (n>b) {
//                        b=n;
//                    }
//                }
//                answer.add(genreDetail.get(genre).get(a));
//                answer.add(genreDetail.get(genre).get(b));
//            }
//        }
//
//        System.out.println(answer);
//
//    }

//    public static void main(String[] args) { // ver4 - ver3의 test 2,15실패 개선
////        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. >> 가 원인인 듯
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
////        String[] genres = {"classic", "pop", "classic", "classic"};
////        int[] plays = {500, 600, 150, 800};
//        // 장르내에 노래가 하나만 있을경우를 고려!!
//
//        int l = genres.length;
//
//        // 장르별 데이터 구분
//        Map<String,Map<Integer,Integer>> genreDetail = new HashMap<>(); // 해당장르의 Map<plays, Index>를 가진다.
//        // !!!오류!!! 특정장르의 plays 에 중복이 존재하면? >> key 값으로 사용할 수 없다! 본질적인 오류!
//        Map<String,Integer> genrePlayTime = new HashMap<>(); // 해당장르의 총 playTime
//        for (int i = 0; i < l; i++) {
//
//            if (genreDetail.containsKey(genres[i])){ // 해당장르 있으면 추가
//                genreDetail.get(genres[i]).put(plays[i],i);
//            }else{ // 해당장르 없으면 새롭게 할당
//                Map<Integer,Integer> newMap = new HashMap<>(); // 장르마다 새로 생성하면 새로운 객체?(다른 참조값?)
//                newMap.put(plays[i],i);
//                genreDetail.put(genres[i], newMap); // 같은값을 참조하여, 중복되기 싶다!! 추후 자세히 검토 필요!
////                newMap.clear();
//            }
//
//            if (genrePlayTime.containsKey(genres[i])){  // 해당장르 있으면 시간 추가
//                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
//            }else{ // 해당장르 없으면 시간 새롭게 할당
//                genrePlayTime.put(genres[i],plays[i]);
//            }
//        }
//        System.out.println("genreDetail = " + genreDetail); // ok
//        System.out.println("genrePlayTime = " + genrePlayTime);
//
//        // 1. 속한노래가 많이 재생된 장르순서 뽑기(중복X)
//        List<String> genreRank = new ArrayList<>(); // 장르 순위 판별
//        int i;
//        for(String genre:genrePlayTime.keySet()){
//            i=0;
//            while (i<genreRank.size()){
//                if(genrePlayTime.get(genreRank.get(i)) > genrePlayTime.get(genre))
//                    i++;
//                else break;
//            }
//            genreRank.add(i,genre); // 로직 검증필요!
//        }
//
//        // 장르순위 확인 test
//        System.out.println("genreRank = " + genreRank);
//
//        // 2. 1.에서 뽑힌 장르순서로, 장르 내 많이 재생된 노래를 두 개 수록
//
//        List<Integer> answer = new ArrayList<>();
//        int a,b;
//
//        for(String genre:genreRank){
//
//            Integer[] top12 = genreDetail.get(genre).keySet().toArray(new Integer[0]);
//            if(top12.length==1){ // 장르에 곡이 하나라면 하나만 수록(예외처리) >> ok
//                answer.add(genreDetail.get(genre).get(top12[0]));
//            }
//            else{
//                a=0;
//                b=0;
//                for (int n:top12){
//                    if(n>a){
//                        b=a;
//                        a=n;
//                    } else if (n>b) {
//                        b=n;
//                    }
//                }
//                // 3. 2.에서 수록할 때, 장르 내 재생 횟수가 같으면(중복이면) 고유 번호가 낮은 노래 먼저 >> !!Working on It
//                if(a==b){
//                    if(genreDetail.get(genre).get(a) < genreDetail.get(genre).get(b)){
//                        answer.add(genreDetail.get(genre).get(a));
//                        answer.add(genreDetail.get(genre).get(b));
//                    }else{
//                        answer.add(genreDetail.get(genre).get(b));
//                        answer.add(genreDetail.get(genre).get(a));
//                    }
//                }else{
//                    answer.add(genreDetail.get(genre).get(a));
//                    answer.add(genreDetail.get(genre).get(b));
//                }
//            }
//        }
//
//        System.out.println(answer);
//
//
//    }


    public static void main(String[] args) { // 처음부터 다시 풀자!

    }
}
