package programmers.level0;

public class ExceptSpecificNumber { // 저주의 숫자 3


    public static void main(String[] args) {
        int n = 15;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer++;
            // 3배수 or 3사용 통과
            while(answer%3==0 || String.valueOf(answer).contains("3")){
                answer++;
            }
        }

    }


}
