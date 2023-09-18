package programmers.level2;

public class SimilarCantorBitArray { // 유사 칸토어 비트열

    public static void main(String[] args) {
        int n = 2; // 1~20
        long l = 4; // 1~5^n
        long r = 17;
        // index 폐구간 [l,r] 에서 1의 갯수를 return



        int answer = 0;
        answer += CantorBeat(n,r);
        answer -= CantorBeat(n,l-1);

        System.out.println("answer = " + answer);
    }


    public static int CantorBeat(int n, long k){
        if(n==1){ // 재귀 종료, 점화식 초항
            if(k<=2) return (int) k;
            return (int) k-1;
        }

        int group = (int) (k/(int) Math.pow(5,n-1));
//        if(group>=3) group--;
//        return (int) Math.pow(4,n-1)*group + CantorBeat(n-1, (long) (k%Math.pow(5,n-1)));

        if(group<=1) return (int) Math.pow(4,n-1)*group + CantorBeat(n-1, (long) (k%Math.pow(5,n-1)));
        if(group==2) return (int) Math.pow(4,n-1)*group;
        // group >=3
        group--;
        return (int) Math.pow(4,n-1)*group + CantorBeat(n-1, (long) (k%Math.pow(5,n-1)));

    }

}
