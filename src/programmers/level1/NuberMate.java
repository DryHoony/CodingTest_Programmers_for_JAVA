package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class NuberMate {  // 숫자짝꿍

    // 문자열에 해당숫자가 몇개나 들어가있는지 확인
    public static int countN(String str, int n){
        int answer = 0;
        for(String s:str.split("")){
            if (Integer.parseInt(s) == n) answer++;
        }

        return answer;
    }

    // 두 숫자(String)에 중복된 숫자(0~9)를 리턴
    public static Map<Integer,Integer> overlapN(String a, String b){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            map.put(i, Math.min(countN(a,i), countN(b,i))); // 여러번 반복하고 a,b자체도 크기때문에 굉장히 비효율적
        }

        return map;
    }

//    public static void main(String[] args) { // ver1 - 런타임 에러
//        String X = "100";
//        String Y = "203045";
//
//        Map<Integer, Integer> overlap = overlapN(X,Y);
//        String answer = "";
//        // 9~1까지 돌고, 0이면 return -1 / 0이 아니면 '0'추가연산 후 return
//        for (int i = 9; i >= 0; i--) {
//            answer += String.valueOf(i).repeat(overlap.get(i));
//        }
//
//        if(answer.equals("")) System.out.println("return -1");
//        else if (Integer.parseInt(answer)==0) System.out.println("return 0");
//        else System.out.println("return answer");
//
//
//    }

//    public static void main(String[] args) { // ver2 - X,Y의 숫자를 map으로 각각 잡아보자, (조금 줄었지만)똑같이 런타임 에러
//        String X = "100";
//        String Y = "2345";
//
//        Map<String,Integer> mapX = new HashMap<>();
//        for (int i = 0; i <= 9; i++) { // 초기화
//            mapX.put(String.valueOf(i),0);
//        }
//        for (String x:X.split("")){  // X의 size 가 클때 여기가 문제가 되는 걸까? 그렇다면 좀 더 가벼운 방법은?
//            mapX.put(x,mapX.get(x)+1);
//        }
//
//        Map<String,Integer> mapY = new HashMap<>();
//        for (int i = 0; i <= 9; i++) { // 초기화
//            mapY.put(String.valueOf(i),0);
//        }
//        for (String y:Y.split("")){
//            mapY.put(y,mapY.get(y)+1);
//        }
//
//        String answer = "";
//        for(int i = 9; i>=0; i--){
//            answer += String.valueOf(i).repeat(Math.min(mapX.get(String.valueOf(i)),mapY.get(String.valueOf(i))));
//        }
//
//        if (answer.equals("")) System.out.println("-1");
//        else if(Integer.parseInt(answer)==0) System.out.println("0");
//        else System.out.println(answer);

//    }

    // Stream 활용, String 에서 char 포함 갯수 세기
    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    // Stream을 활용하여 풀긴 풀었다. But, Stream에 대한 이해,활용능력이 부족 >> 추후 학습 필요
    public static void main(String[] args) { // ver3, X,Y가 String 타입의 상당히 큰 정수임을 고려해보자, 어떻게 다뤄야 할까?
        String X = "100";
        String Y = "2345";
        String answer = "";

        //연산
//        for (int i =9; i>=0; i--){
//            answer += String.valueOf(i).repeat(i);
//            System.out.println(countChar(Y, i)); // int 를 char로 어떻게 바꾸지?
//        }

        answer += "9".repeat((int) Math.min(countChar(X,'9'),(int) countChar(Y,'9')));
        answer += "8".repeat((int) Math.min(countChar(X,'8'),(int) countChar(Y,'8')));
        answer += "7".repeat((int) Math.min(countChar(X,'7'),(int) countChar(Y,'7')));
        answer += "6".repeat((int) Math.min(countChar(X,'6'),(int) countChar(Y,'6')));
        answer += "5".repeat((int) Math.min(countChar(X,'5'),(int) countChar(Y,'5')));
        answer += "4".repeat((int) Math.min(countChar(X,'4'),(int) countChar(Y,'4')));
        answer += "3".repeat((int) Math.min(countChar(X,'3'),(int) countChar(Y,'3')));
        answer += "2".repeat((int) Math.min(countChar(X,'2'),(int) countChar(Y,'2')));
        answer += "1".repeat((int) Math.min(countChar(X,'1'),(int) countChar(Y,'1')));
        answer += "0".repeat((int) Math.min(countChar(X,'0'),(int) countChar(Y,'0')));




        // 결과
        if (answer.equals("")) System.out.println("-1");
//        else if(Integer.parseInt(answer)==0) System.out.println("0"); // 숫자가 크면 곤란,,
        else if(answer.charAt(0) == '0') System.out.println("0"); // 앞자리가 0인걸로 확인
        else System.out.println(answer);

    }

}
