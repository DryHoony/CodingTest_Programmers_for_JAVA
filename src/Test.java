import programmers.level0.ReverseArray;


public class Test {

    public int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Test t = new Test();

        int n=30;
        int r=15;

        // 분수(fraction)
        int[] numArray = new int[r]; // 분자(numerator),
        int[] denArray = new int[r]; // 분모(denominator)

        for (int i = 0; i < r; i++) {
            numArray[i] = n-i;
            denArray[i] = r-i;
        }
        // 생성완료

        int j;
        int g;
        for (int i = 0; i < r; i++) { //분모(den)의 index

            // 분모(den)의 인자에 대해서 분자(num)에서 약분을 시행한다.
            j=0; // 초기화
            while(denArray[i]!=1){
                g = t.gcd(numArray[j],denArray[i]);
                if(g>=2){ // 약분이 된다면 - 나누어 떨어지는 것이 아닌 gcd가 2이상이면

                    numArray[j] /= g;
                    denArray[i] /= g;
                }

                j++;
            }
        }

        // 분자array의 인자를 모두 곱한 값 return
        int answer = 1;
        for(int na:numArray){
            answer *= na;
        }
        System.out.println(answer);






    }


}
