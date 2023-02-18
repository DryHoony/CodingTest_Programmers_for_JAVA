public class Test2 {

    public int gcd(int a, int b){

        //종료조건
        if (a%b==0) return b;
        //재귀
        return gcd(b,a%b);
    }


    public static void main(String[] args) {
        Test2 t = new Test2();

        System.out.println(t.gcd(100,17));
    }

}
