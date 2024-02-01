package programmers.level2;

public class NumberBlock { // 숫자블록
    // n 번째 연산 : n보다 큰 'n배수' 위치에 n을 할당(덮어쓰기) >> index[n*i] 위치에 할당
    // 문제이해!! - 숫자블록은 1~10,000,000 까지!! >> 주어진 범위보다 작다!

    // 방법1 : DP 이용 >> 범위를 1~end 까지 설정하고 처음부터 연산
    // 방법2 : 각각의 n에 'n보다 작은 최대 약수' 를 할당 연산 >> No!!! 이해를 잘못했다.

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
    
    
    // ver2.3 - 방법2 >> 정확성 통과!!, 효율성 Fail!!
    // MaxDivisor3 메소드로 변경
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
//        long begin = 100000014;
//        long end = 100000016;
        
        int[] answer = new int[(int) (end-begin)+1];
        System.out.println("answer 길이= " + answer.length);
        // 연산
        for (int i = 0; i < answer.length; i++) {
            answer[i] = MaxDivisor3(i+(int) begin);
        }

        System.out.println("answer 출력확인");
        for (int a:answer){
            System.out.print(a+" ");
        }
//        System.out.println("답은 = ");
    }


    
    public static int MaxDivisor(int k){ // k보다 작은 최대 약수 return
        int start = Math.min(10000000, k/2);
        for (int i = start; i > 0 ; i--) {
            if(k%i==0) return i;
        }
        return 0;
    }

    public static int MaxDivisor2(int k){ // k보다 작은 최대 약수 return, 양방향 연산 1~10,000,000
        if(k==1) return 0;

        int top = Math.min(10000000, k/2);
        int bottom = 2;
        int bottomDivisor=1;

        while(bottom <= top){
            if(k%top==0) {
//                System.out.println("top 에 연산걸림 = " + top);
                return top;
            }
            if(k%bottom==0){
                // k/bottom <10000000
                if(k/bottom < 10000000) return k/bottom;
                else bottomDivisor = bottom;
            }

            top--;
            bottom++;
        }

        return bottomDivisor;
    }

    public static int MaxDivisor3(int k){ // // k보다 작은 최대 약수 return, 제곱근 범위내 연산
        if(k==1) return 0;
        int sqrtLimit = Math.min(10000000, (int)Math.sqrt(k));
        int bottom = 2;
        int bottomDivisor=1;

        while (bottom<=sqrtLimit){
            if(k%bottom==0){
                if(k/bottom <= 10000000) return k/bottom;
                bottomDivisor = bottom;
            }

            bottom++;
        }

        return bottomDivisor;
    }
}
