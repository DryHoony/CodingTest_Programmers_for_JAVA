package programmers.level0;

public class AgeOfExoplanets { // 외계행성의 나이

    public String solution(int age) {
        String answer = "";
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j"};

        while(age>0){
            answer = alpha[age%10] + answer;
            age /= 10;
        }

        return answer;
    }

}
