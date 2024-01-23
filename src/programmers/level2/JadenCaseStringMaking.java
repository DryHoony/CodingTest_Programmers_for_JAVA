package programmers.level2;

import java.util.Locale;

public class JadenCaseStringMaking { // JadenCase 문자열 만들기
    // 모든 '단어'의 첫 문자가(알파벳일때) 대문자, 그 외는 소문자
    // 공백문자가 연속해서 나올 수 있다!!!

    // ver1
    public static void mai1(String[] args) {
        String s = "3people unFollowed me";

        // 연산용 변수
        String answer = "";

        // 연산
        for (String word : s.split(" ")){
//            System.out.print(word + " >> ");
//            System.out.println(word.replace("p", "X")); // 모두 바꾼다 ㄴㄴ
//            System.out.println(word.replaceFirst("p", "X"));
//            System.out.println(word.substring(0,1));
//            System.out.println(word.replaceFirst(word.substring(0,1), word.substring(0,1).toUpperCase()));
//            answer += word.replaceFirst(word.substring(0,1), word.substring(0,1).toUpperCase()) + " ";
            // 나머지 lowercase 추가
            answer += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }

//        System.out.println("끝 공백 제거");
        System.out.println(answer.substring(0, answer.length()-1));

//        System.out.println("답은 = ");
    }

    public static void main(String[] args) {
//        String s = "3people unFollowed me";
        String s = "one two  three    four";
        boolean spaceUnDone = true;
        boolean firstLetter = true;
        String answer = "";


        for(String letter:s.split("")){

            if(letter.equals(" ")){ // 1. 공백
                if (spaceUnDone){
                    answer += " ";
                    spaceUnDone = false;
                    firstLetter = true;
                }
            }
            else { // 2. 단어
                if(firstLetter){ // 첫글자
                    answer += letter.toUpperCase();
                    spaceUnDone = true;
                    firstLetter = false;
                }
                else { // 뒷글자
                    answer += letter.toLowerCase();
                }
            }

        }

        answer.trim();
        System.out.println("답은 = " + answer);
    }
}
