package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    // 소수판별 - 숫자하나만 주어졌을 때 유용
    public static boolean primeCheck(int n){
        for(int i=2; i<= (int)Math.sqrt(n); i++){
            if(n%i==0) return false;
        }

        return true;
    }

    // 에라토스테네스의 체 - 범위내 소수집합 구하기
    // 동적으로 크기가 변화해야 하므로 array를 사용하지 않고 list를 사용
    public static List<Integer> eratos(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add(i);
        }
        int pindex = 0;
        int p;
        int i;

        while(pindex < list.size()){
            p = list.get(pindex);

            // list내에서 p의 배수 제거 - list의 size가 바뀜에 주의
            i=pindex+1;
            while(i< list.size()){
                if(list.get(i)%p==0){
                    list.remove(i);
                    continue;
                }
                i++;
            }
//            int finalP = p;
//            list.removeIf(q -> q% finalP ==0); // p는 남겨야 하는데 제거된다

            pindex++;
        }

        return list;
    }

    // 소인수분해
    public static List<Integer> primeFactors(int n){
        List<Integer> pfactors = new ArrayList<>();


        int p;
        while(n>1){ // 종료조건 n==1
            // n이하의 가장 작은 소인수p 찾기
            p = 2;
            while(!(primeCheck(p) && n%p==0)){ // p가 n의 소인수일때 종료
                p++;
                if (p==n) break;
            }
            // n을 p로 나누고, p를 pfactors에 추가
            n/=p;
            pfactors.add(p);
        }

        return pfactors;
    }

    // 소인수집합 중복제거ver
    public static List<Integer> primeFactors2(int n){
        List<Integer> pfactors = new ArrayList<>();

        int p;
        while(n>1){ // 종료조건 n==1
            // n이하의 가장 작은 소인수p 찾기
            p = 2;
            while(!(primeCheck(p) && n%p==0)){ // p가 n의 소인수일때 종료
                p++;
                if (p==n) break;
            }
            // n을 p로 가능한만큼 나누고, p를 pfactors에 추가
            while(n%p==0) n/=p;
            pfactors.add(p);
        }

        return pfactors;
    }


    public static void main(String[] args) {
//        PrimeNumber pClass = new PrimeNumber();

        int n = 100;
        System.out.println(primeFactors2(420));

//        System.out.println(eratos(n));
//        System.out.println(eratos(n).size());
















    }

}
