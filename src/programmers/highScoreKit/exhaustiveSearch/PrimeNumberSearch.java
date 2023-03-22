package programmers.highScoreKit.exhaustiveSearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberSearch { // 소수찾기

    // 소수판별 0,1 return
    public static int primeCheck(int n){
        if(n<=1) return 0;

        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(n%i==0) return 0;
        }
        return 1;
    }

    // 문자열 사이에 문자 추가(모든 위치에)
    public static String[] insert(String n, String c){
        if(n.equals("")){ // 이때는 길이가 2인 array return
            return new String[]{"", c};
        }

        String[] answer = new String[n.length()+2]; // 길이가 l+2 return
        answer[0] = n;
        String newn;

        for (int i = 0; i < n.length(); i++) {
            newn = n.substring(0,i) + c + n.substring(i,n.length());
            answer[i+1] = newn;

        }
        answer[n.length()+1] = n.substring(0,n.length()) + c;

        return answer;
    }

    // 소수 찾기
//    public static int primeMakingSearch(String list){
//        return primeMakingSearchRecursion("", list);
//    }
//
//    public static int primeMakingSearchRecursion(String n, String list){
//        int count=0;
//        String c = list.substring(0,1);
//        list = list.substring(1);
//
//        // 재귀
//        for (String str:insert(n,c)){
//            count += primeMakingSearchRecursionCount(str, list);
//        }
//
//
//        return count;
//    }
//
//    public static int primeMakingSearchRecursionCount(String n, String list){
//        if(list.length()==0){ // 재귀 연산 마지막부분
//            if(n.equals("")) return 0;
//            else return primeCheck(Integer.parseInt(n));
//        }
//
//        // 재귀
//        return primeMakingSearchRecursion(n, list);
//    }


    public static void main(String[] args) { // ver1 - nice
        String numbers = "0123"; // 길이 1~7
        // 범위가 작으므로 다른 소수 테크닉 사용하지 않고 브루트 포스로 연산
        // 구성할 수 있는 모든 숫자를 만들고 count
        // 011 같은 형태 주의 Integer.parseInt 사용하자
        // 중복 되면 안된다!! - Set사용


//        System.out.println(primeMakingSearch(numbers));

        Set<String> set = new HashSet<>();
        set.add("");
        Set<String> set0 = new HashSet<>(Set.copyOf(set)); // 연산용


        for(String c:numbers.split("")){
            // n-set 연산
            for(String n:set){
                set0.addAll(Arrays.asList(insert(n, c)));
            }

            set = Set.copyOf(set0);
        }

        System.out.println(set);
        // 숫자로 바꾼후 Set연산 (중복제거)
        Set<Integer> setN = new HashSet<>();
        for (String n:set){
            if(!n.equals("")){
                setN.add(Integer.valueOf(n));
            }
        }

        System.out.println(setN);
        int count=0;
        for(int n:setN){
            count += primeCheck(n);
        }

        System.out.println(count);
















    }

}
