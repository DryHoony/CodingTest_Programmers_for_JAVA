package programmers.level0;

public class StringSpecificChange { // 인덱스 바꾸기

    // String의 특정 index를 s로 바꾸기
    public static String changeIndex(String str, int i, String s){
        str = str.substring(0,i) + s + str.substring(i+1,str.length());
        return str;
    }

    // String의 index n,m을 서로 바꾸기
    public static String swap(String str, int n, int m){
        String s = str.substring(n,n+1);
        str = changeIndex(str,n,str.substring(m,m+1)); // n할당
        str = changeIndex(str,m,s); //m할당

        return str;
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(swap(str,0,4));

    }
}
