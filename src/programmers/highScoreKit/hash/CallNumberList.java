package programmers.highScoreKit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CallNumberList { // 전화번호 목록

//    public static void main(String[] args) { // ver1 - 생각나는대로 먼저 시도 // 8,9,19실패 효율성 낮음
//        String[] phone_book = {"12","123","1235","567","88"};
//        String n;
//
//        for (int i = 0; i < phone_book.length-1; i++) {
//            for (int j = i+1; j < phone_book.length; j++) {
//                n = phone_book[i];
//                if (phone_book[j].length()>=n.length()){
//                    if(phone_book[j].substring(0,n.length()).equals(n)){
//                        System.out.println("false");
//                    }
//                }
//
//            }
//        }
//
//        // 결과
//        System.out.println("앞서 false가 없을때만 true");
//    }

//    public static void main(String[] args) { // ver2 - HashMap이용 // 효율성 ok, But 8,9,19 오답
//        // 접두어 형태를 Map 으로 저장해서 비교
//        String[] phone_book = {"123","456","789"};
//
//        Map<String, Boolean> prefix = new HashMap<>();
//
//        int i;
//        boolean flag;
//        for (String n:phone_book){
//            // phone_book[i] 을 .subString(0,k) k를 1부터 끝까지 해서 prefix 에 존재하는지 검증
//            i=1;
//            flag = true;
//            while(i<=n.length()){
//                if(prefix.containsKey(n.substring(0,i))){
//                    flag = false;
//                    break;
//                }
//                i++;
//            }
//            // 존재하면 false(종료), 없으면 prefix.put
//            if(flag){
//                prefix.put(n,true);
//            }
//            else{
//                System.out.println("false");
//                break;
//            }
//
//        }
//
//        System.out.println("앞서 false가 출력되지 않으면 true");
//    }

    public static void main(String[] args) { // ver3 - ver2에서 오류찾아 개선
        // 반례 "1192456", "119" >> 접두어가 맨 마지막에 나오는 경우
        // "1192456"은 이미 prefix 에 들어가 있으므로, 1192456은 접두어가 아님을 확인하는 연산만 한다.
        // 반복문에서 119가 접두어인지 검사가 빠져있고, 접두어로 이루어졌는지만 검사만 한다. >> sort로 해결

        String[] phone_book = {"1192456", "119"};
        Arrays.sort(phone_book);

        Map<String, Boolean> prefix = new HashMap<>();

        int i;
        boolean flag;
        for (String n:phone_book){
            // phone_book[i] 을 .subString(0,k) k를 1부터 끝까지 해서 prefix 에 존재하는지 검증
            i=1;
            flag = true;
            while(i<=n.length()){
                if(prefix.containsKey(n.substring(0,i))){
                    flag = false;
                    break;
                }
                i++;
            }
            // 존재하면 false(종료), 없으면 prefix.put
            if(flag){
                prefix.put(n,true);
            }
            else{
                System.out.println("false");
                break;
            }

//            System.out.println(prefix);

        }

        System.out.println("앞서 false가 출력되지 않으면 true");
    }
}
