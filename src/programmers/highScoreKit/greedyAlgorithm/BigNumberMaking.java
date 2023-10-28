package programmers.highScoreKit.greedyAlgorithm;

public class BigNumberMaking { // 큰 수 만들기

    public static void main(String[] args) {
        String number = "4177252841"; // 자릿수 2~1,000,000
        int k = 4; // 1~number.length
        // number 에서 4개를 제거 >> 가장 큰 수 return
        // number 의 숫자 순서를 유지


        // 연산용 변수
        int[] digitArray = new int[10]; // digit[i]는 i 숫자의 갯수
        for (String str:number.split("")){
            digitArray[Integer.parseInt(str)]++;
        }


        // 연산1 - digitArray 에서 작은수부터 k갯수 만큼 제거
        for (int i = 0; i < 10; i++) {
            if(digitArray[i] < k){
                k -= digitArray[i];
                digitArray[i] = 0;
            }
            else { // digitArray[i] == k
                digitArray[i] = 0;
                k = 0;
                break;
            }
        }


        // 연산2 - digitArray 를 큰 수부터 String 형태로 변환
        String answer = "";
        for (int i = 9; i >= 0; i--) {
            System.out.println(digitArray[i]);
        }


        System.out.println("답은 = " + answer);
    }





}
