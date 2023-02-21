package programmers.level0;

import java.util.Locale;

public class StringUpperLower {

    // 대문자 확인
    public static boolean checkUpper(String s){
        if (Character.isUpperCase(s.charAt(0))) return true;
        else return false; // 소문자 확인
    }

    // 대소문자 변환
    public static String upLowChange(String str){
        String answer="";
        for(String s:str.split("")){
            if (checkUpper(s)) answer+= s.toLowerCase();
            else answer += s.toUpperCase();
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "Hello";

//        for(String s:str.split("")){
//            System.out.println(s + "는 대문자" + checkUpper(s));
//        }

        System.out.println(upLowChange(str));

    }

}
