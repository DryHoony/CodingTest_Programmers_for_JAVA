package programmers.level0;

public class BinarySystem {

    // 이진수로 변환, 직접구현
//    String s = Integer.toBinaryString(127);
    public static String binaryCovert(int n){ //직접구현
        int l = 1;
        while(Math.pow(2,l)<=n){
            l++;
        }
        l--; //이진수의 길이는 l+1

        String answer="";
        for (int i = l; i >=0; i--) {
            if((int)Math.pow(2,i) <= n){
                n -= (int)Math.pow(2,i);
                answer+="1";
            }else answer+="0";
        }
        return answer;
    }

    // 십진수 변환
//    int i = Integer.parseInt("1001",2); // 2진수에서 10진수 변환

    // 이진수 덧셈연산
    public static String binaryPlus(String bin1, String bin2){

        int b1 = Integer.parseInt(bin1,2);
        int b2 = Integer.parseInt(bin2, 2);

        return Integer.toBinaryString(b1+b2);
    } // 메소드 이용
    public static String binaryPlus2(String bin1, String bin2){ //직접 구현
        return null;
    }

    public static void main(String[] args) {
        System.out.println(binaryCovert(77));

    }
}
