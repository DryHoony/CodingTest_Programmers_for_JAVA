package programmers.level0;

public class RemoveSpecificChar { // 특정 문자 제거

    public String solution(String my_string, String letter) {
        String answer = my_string.replace(letter,"");

        return answer;
    }



}
