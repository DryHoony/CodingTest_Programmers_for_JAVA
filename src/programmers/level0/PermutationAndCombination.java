package programmers.level0;

public class PermutationAndCombination { //순열과 조합
    // int에 담기에는 범위가 너무 작다, long에 담자

    //팩토리얼
    public long Factorial(int n){
        if(n==0) return 1;

        // int를 사용하면 f(12)까지만 맞음, long은 f(20)까지 맞음, 더 늘릴수는 없을까?
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    //순열
    public long Permutation(int n, int r){
//        return this.Factorial(n) / this.Factorial(n-r); //비효율적

        long answer = 1;

        for (int i = n; i >= n-r+1 ; i--) {
            answer*=i;
        }

        return answer;
    }

    // gcd, 최대공약수, 유클리드 알고리즘
    public int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b, a%b);
    }

    // lcm, 최대공약수
    public int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    //조합
    public long Combination(int n, int r){
//        return this.Permutation(n,r) / this.Factorial(r); //비효율적

        if(r>n-r) return Combination(n,n-r);

        // 분수(fraction)
        int[] numArray = new int[r]; // 분자(numerator),
        int[] denArray = new int[r]; // 분모(denominator)

        for (int i = 0; i < r; i++) {
            numArray[i] = n-i;
            denArray[i] = r-i;
        }

        int j;
        int g;
        for (int i = 0; i < r; i++) { //분모(den)의 index

            // 분모(den)의 인자에 대해서 분자(num)에서 약분을 시행한다.
            j=0; // 초기화
            while(denArray[i]!=1){
                g = this.gcd(numArray[j],denArray[i]);
                if(g>=2){ // 약분이 된다면 - 나누어 떨어지는 것이 아닌 gcd가 2이상이면

                    numArray[j] /= g;
                    denArray[i] /= g;
                }

                j++;
            }
        }

        long answer = 1;
        for(int na:numArray){
            answer *= na;
        }

        return answer;
    }





    public static void main(String[] args) {
        PermutationAndCombination pc = new PermutationAndCombination();

        for (int i = 1; i <= 60; i++) {
//            System.out.println("F(" + i + ")는" + pc.Factorial(i)); // f(20)까지 ok
//            System.out.println("P(20," + i + ")는" + pc.Permutation(20,i));
            System.out.println("C(60,"+i+")는 " + pc.Combination(60,i));
        }






    }

}
