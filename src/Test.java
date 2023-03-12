import java.util.*;

public class Test {


    public static void main(String[] args) { // ver4 - ver3의 test 2,15실패 개선
//        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. >> 가 원인인 듯
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
//        String[] genres = {"classic", "pop", "classic", "classic"};
//        int[] plays = {500, 600, 150, 800};
        // 장르내에 노래가 하나만 있을경우를 고려!!

        int l = genres.length;

        // 장르별 데이터 구분
        Map<String,Map<Integer,Integer>> genreDetail = new HashMap<>(); // 해당장르의 Map<plays, Index>를 가진다.
        // !!!오류!!! 특정장르의 plays 에 중복이 존재하면? >> key 값으로 사용할 수 없다! 본질적인 오류!
        Map<String,Integer> genrePlayTime = new HashMap<>(); // 해당장르의 총 playTime
        for (int i = 0; i < l; i++) {

            if (genreDetail.containsKey(genres[i])){ // 해당장르 있으면 추가
                genreDetail.get(genres[i]).put(plays[i],i);
            }else{ // 해당장르 없으면 새롭게 할당
                Map<Integer,Integer> newMap = new HashMap<>(); // 장르마다 새로 생성하면 새로운 객체?(다른 참조값?)
                newMap.put(plays[i],i);
                genreDetail.put(genres[i], newMap); // 같은값을 참조하여, 중복되기 싶다!! 추후 자세히 검토 필요!
//                newMap.clear();
            }

            if (genrePlayTime.containsKey(genres[i])){  // 해당장르 있으면 시간 추가
                genrePlayTime.put(genres[i], plays[i] + genrePlayTime.get(genres[i]));
            }else{ // 해당장르 없으면 시간 새롭게 할당
                genrePlayTime.put(genres[i],plays[i]);
            }
        }
        System.out.println("genreDetail = " + genreDetail); // ok
        System.out.println("genrePlayTime = " + genrePlayTime);

        // 1. 속한노래가 많이 재생된 장르순서 뽑기(중복X)
        List<String> genreRank = new ArrayList<>(); // 장르 순위 판별
        int i;
        for(String genre:genrePlayTime.keySet()){
            i=0;
            while (i<genreRank.size()){
                if(genrePlayTime.get(genreRank.get(i)) > genrePlayTime.get(genre))
                    i++;
                else break;
            }
            genreRank.add(i,genre); // 로직 검증필요!
        }

        // 장르순위 확인 test
        System.out.println("genreRank = " + genreRank);

        // 2. 1.에서 뽑힌 장르순서로, 장르 내 많이 재생된 노래를 두 개 수록

        List<Integer> answer = new ArrayList<>();
        int a,b;

        for(String genre:genreRank){

            Integer[] top12 = genreDetail.get(genre).keySet().toArray(new Integer[0]);
            if(top12.length==1){ // 장르에 곡이 하나라면 하나만 수록(예외처리) >> ok
                answer.add(genreDetail.get(genre).get(top12[0]));
            }
            else{
                a=0;
                b=0;
                for (int n:top12){
                    if(n>a){
                        b=a;
                        a=n;
                    } else if (n>b) {
                        b=n;
                    }
                }
                // 3. 2.에서 수록할 때, 장르 내 재생 횟수가 같으면(중복이면) 고유 번호가 낮은 노래 먼저 >> !!Working on It
                if(a==b){
                    if(genreDetail.get(genre).get(a) < genreDetail.get(genre).get(b)){
                        answer.add(genreDetail.get(genre).get(a));
                        answer.add(genreDetail.get(genre).get(b));
                    }else{
                        answer.add(genreDetail.get(genre).get(b));
                        answer.add(genreDetail.get(genre).get(a));
                    }
                }else{
                    answer.add(genreDetail.get(genre).get(a));
                    answer.add(genreDetail.get(genre).get(b));
                }
            }
        }

        System.out.println(answer);


    }


}









