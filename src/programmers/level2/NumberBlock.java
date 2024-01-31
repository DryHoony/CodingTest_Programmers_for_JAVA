package programmers.level2;

public class NumberBlock { // 숫자블록
    // n 번째 연산 : n보다 큰 'n배수' 위치에 n을 할당(덮어쓰기) >> index[n*i] 위치에 할당

    // 방법1 : DP 이용 >> 범위를 1~end 까지 설정하고 처음부터 연산
    // 방법 1.1 : 절반 부터 시작해서, 내림차순으로 연산, if(!0) 일때만 할당하면 될듯
    // 방법2 : 각각의 n에 'n보다 작은 최대 약수' 를 할당 연산

    // ver1 방법1
    public static void main1(String[] args) {
        long begin = 1;
        long end = 10;

        // 연산용 변수
        int[] answer = new int[(int) end];
        int x;

        // 연산
        for (int i = 1; i <= end/2; i++) {
            x = i*2;
            while (x<=end){
                answer[x-1]=i; // 할당
                x+=i; // 다음
            }
        }


        // 중간 확인 answer 출력
        System.out.println("answer = " + answer);
        for (int a:answer){
            System.out.println(a + " ");
        }
        System.out.println();

        // begin ~ end 답 범위 할당
        int[] answer0 = new int[(int)(end-begin) + 1];
        for (int i = 0; i < answer0.length; i++) {
            answer0[i] = answer[i+(int)begin-1];
        }

        System.out.println("답은 = ");
    }
    
    
    // ver2
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        
        int[] answer = new int[(int) (end-begin)+1];
        // 연산
        for (int i = 0; i < answer.length; i++) {
            answer[i] = MaxDivisor(i+1);
        }

        System.out.println("answer 출력확인");
        for (int a:answer){
            System.out.print(a+" ");
        }
//        System.out.println("답은 = ");
    }
    
    public static int MaxDivisor(int k){ // k보다 작은 최대 약수 return
        for (int i = k-1; i > 0 ; i--) {
            if(k%i==0) return i;
        }
        return 0;
    }
}
