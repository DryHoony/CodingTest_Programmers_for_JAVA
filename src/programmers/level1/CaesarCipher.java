package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarCipher { //카이사르 암호, 시저 암호 - 치환암호

    // 알파벳 s를 n만큼 뒤로 이동
    public static String push(String s, int n){ //소문자 연산
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int i = (Arrays.asList(alpha).indexOf(s)+n)%26;

        return alpha[i];
    }

    public static String cipher(String s, int n){ //소문자, 대문자, 공백연산
        if(s.equals(" ")) return " "; //공백
        else if (Character.isUpperCase(s.charAt(0))) { // 대문자
            s = s.toLowerCase();
            s = push(s,n);
            return s.toUpperCase();
        }else return push(s,n);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(push("s",i));
        }
    }
}
