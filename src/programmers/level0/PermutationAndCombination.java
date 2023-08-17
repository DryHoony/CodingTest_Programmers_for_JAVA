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

    //순열 - 숫자만 계산
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
        // 순열
        int[] mix = {1,2,3,4};
        int depth = mix.length;

        // Swap 을 이용한 순열 출력(순열이라기 보단 팩토리얼 모든 케이스 같은데??)
        permutation1(mix, 0, mix.length, 4);
        int[][] result;

    }




    // 순열 - 모든 경우를 출력(println) / 참고 - https://bcp0109.tistory.com/14
    static void permutation1(int[] arr, int depth, int n, int r){
        // 재귀함수를 이용한다.
        if (depth == r){ // 종료조건
            // arr 출력
            for (int i:arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation1(arr, depth+1, n, r);
            swap(arr, depth, i);
            // swap한 케이스에 대해 재귀로 돌리고, 다른 swap연산을 하기 위해 원상복구
        }

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
