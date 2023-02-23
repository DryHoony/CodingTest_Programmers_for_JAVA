package programmers.level1;

public class CollatzConjecture {

    public static long collatz(long n){
        if(n%2==0) return n/2;
        else return 3*n +1 ;
    }

    public static long collatzCount(long n){
        int count =0;
        while(n!=1){
            n = collatz(n);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(collatzCount(626331));
    }
}
