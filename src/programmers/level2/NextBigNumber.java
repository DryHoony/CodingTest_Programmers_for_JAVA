package programmers.level2;

public class NextBigNumber { // 다음 큰 숫자
    // 조건1. n보다 큰 자연수
    // 조건2. 2진수 변환시 n과 1의 갯수가 같음
    // 조건3. 조건 1,2를 만족하는 수중 가장 작은 수

    public static void main(String[] args) {
        int n = 15; // 1~1,000,000

        // 연산용 변수
        int oneCount = binaryOneCount(n);
        while (true){
            n++;
            if(oneCount == binaryOneCount(n)){
                System.out.println("답은 = " + n);
                break;
            }
        }


    }


    public static String binaryConvert(int n){
        String answer = "";
        while (n>0){
            answer = n%2 + answer;
            n /= 2;
        }

        return answer;
    }

    public static int binaryOneCount(int n){
        int count=0;
        while (n>0){
            if(n%2==1) count++;
            n /= 2;
        }

        return count;
    }
}
