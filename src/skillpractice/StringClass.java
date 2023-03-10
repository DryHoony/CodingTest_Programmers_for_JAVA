package skillpractice;

import programmers.level0.*;

import java.util.Locale;

public class StringClass {
    // 스트링 String클래스는 불변(immutatable)클래스
    // 단, String은 클래스로서 기본타입이 아닌 참조타입이다. 참조하는 주소값을 바꾸는 것으로 실질적인 변경은 가능하다.


    public static void main(String[] args) {
        String str = "String"; // ""로 생성해야 한다, ''로 생성하면 오류

        String s = String.valueOf(5); // String으로 변환

        // 길이
        str.length();

        // 추가하기
        str += " plus";

        // 자르기(slice) subString
        String sub = str.substring(0); // 특정인덱스부터 끝까지 새로운 문자열로 반환
        String sub2 = str.substring(2,4); // 특정인덱스부터 특정인덱스까지 새로운 문자열로 반환, 인덱스 벗어남 주의! - Exception
        CipherCode cipher = new CipherCode(); // 응용
        StringSpecificChange change = new StringSpecificChange(); // 특정 인덱스 바꾸기

        str = str.trim(); // 양끝 공백 제거

        // 공백으로 쪼개기 - split(" ")
        String [] strList1 = str.split(" ");

        // 배열로 반환 - split("")
        String[] strList2 = str.split("");
//        for(String s:strList){
//            System.out.println(s);
//        }


        StirngToNumber st = new StirngToNumber(); // 숫자판별, 숫자로변환
        String ns = String.valueOf(100);// 숫자를 문자로 변환

        // 한글자씩 판별
        Character.isDigit('5'); // 숫자 판별
        Character.isAlphabetic('a'); // 알파벳 판별
        Character.isLetter('a'); // 위와 동일, 영어일 경우 차이X


        StringUpperLower uplow = new StringUpperLower();// 대소문자 판별
        String u = str.toUpperCase(Locale.ROOT); // 대소문자 변환

        StringSort stringSort = new StringSort();// 정렬

        // 검색
        // 특정 '문자' '문자열' 검색(첫 등장 인덱스 반환)  indexOf(String)
        // 특정인덱스 이후로 검색(첫 등장 인덱스 반환) indexOf(String, int)
        // 특정 문자가 마지막 등장 인덱스 반환 lastIndexOf(int ch)
        // 특정 인덱스 이후로, 특정 문자가 마지막 등장 인덱스 반환 lastIndexOf(int ch, int)
        StringSearch search = new StringSearch(); // 문자열안에 문자열 검색

        // 대체하기, 바꾸기 - replace
        String newStr = str.replace("S", "NewS"); // str은 바뀌지 않는다.
//        String newStr = str.replace("S", ""); // 특정문자 제거도 가능
//        System.out.println(newStr);
        // replace, replaceAll - 여러문자 한번에 바꾸기, 제거
        StringReplace sr = new StringReplace();

        //비교하기 - compareTo
        int i = str.compareTo("String"); // 같으면 0반환, 사전순 비교이므로 작으면 음수 크면 양수 반환
        int j = str.compareToIgnoreCase("STRING"); // compareTo와 다르게 대소문자 구분X

        // 인덱스 반환 - charAt
//        for(int i=0; i<str.length(); i++){
//            System.out.println(str.charAt(i)); // char타입을 반환해준다.
//        }
        String r = String.valueOf(str.charAt(0)); // 잘라서 String 타입으로 변환해 사용


        // 뒤집기 - StringBuilder 이용
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        String reverseStr = sb.toString();

        // 반복출력 - String.repeat
//        System.out.println(str.repeat(3));
//        for(int i=1; i<4; i++){
//            System.out.println(str.repeat(i));
//        }



        Babbling bab = new Babbling();// 단어조합



    }








}
