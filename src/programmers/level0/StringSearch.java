package programmers.level0;

public class StringSearch {

    //문자열안에 문자열 검색
    public static boolean search(String str,String s){ //str안에 s있는지 확인
        int i = 0; // 매칭시작 Index

        while(i<str.length()){

            if(str.charAt(i)!=s.charAt(0)){ // 첫글자 다르면 pass
                i++;
                continue;
            }else if(str.length()-i >= s.length()){ // 남은길이가 충분할때 str의 index i부터 s전체 매치확인
                if(str.substring(i,i+s.length()).equals(s)) return true;
            }

            i++;
        }

        // 조건문 다 돌때까지 없으면
        return false;
    }

    public static void main(String[] args) {

    }
}
