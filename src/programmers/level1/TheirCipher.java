package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class TheirCipher { // 둘만의 암호

    // 알파벳 s를 n만큼 뒤로 이동
    public static String push(String s, int n){ //소문자 연산
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int i = (Arrays.asList(alpha).indexOf(s)+n)%26;

        return alpha[i];
    }

    // push 연산에 skip 추가
    public static String skipPush(String s,int n, String skip){
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<Integer> skipTest = new ArrayList<>();
        for(String sk:skip.split("")){
            skipTest.add(Arrays.asList(alpha).indexOf(sk));
        }

        int i = Arrays.asList(alpha).indexOf(s); // 초기화
        for (int j = 0; j < n; j++) { // n만큼 추가
            // 초기 s값이 skip 에 들어가 있으면 초기연산 따로 필요 - 일단 없이 진행

            i++; //연산
            i = i%26;

            while (skipTest.contains(i)){ // 스킵연산
                i++;
                i = i%26;
            }


        }


        return alpha[i];
    }

    public static void main(String[] args) {
        // s를 index만큼 뒤로 미룬다, 단 skip에 있는 문자는 건너 뛴다.
        String str = "aukks";
        String skip = "wbqd";
        int index = 5;

        String answer = "";

        // skipPush 확인 test - ok
        for (String s:str.split("")){
//            System.out.println(skipPush(s, index, skip));
            answer += skipPush(s, index, skip);
        }

        System.out.println(answer);

    }
}
