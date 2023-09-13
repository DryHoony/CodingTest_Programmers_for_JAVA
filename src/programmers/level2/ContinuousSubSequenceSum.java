package programmers.level2;

public class ContinuousSubSequenceSum { // 연속된 부분수열의 합
    // 연산 앞에서 부터 - 가장 짧은 수열을 찾기까지 가능한 부분수열을 모두 탐색
    // 연산 뒤에서 부터 - 가장 짧은 수열이 여러 개 일때, 답(앞쪽 수열) 보장 안됨 - 수열길이가 달라 질때 까지 추가 연산으로 확인

    public static void main(String[] args) { // ver3 - 첫번째 연산에서 sum 연산을 최적화 시켜 보자
        int[] sequence = {2, 2, 2, 2, 2}; // 길이 5~1,000,000
        int k =6; // 5~1,000,000,000, 항상 만들 수 있음
        // 합이 k인 부분수열 중 가장 짧은 길이 index[a,b] return, 여러개라면 앞쪽 수열 return


        // 연산용 변수
        int l = sequence.length;
        int sum=0;

        int[] result = new int[] {l-1,l-1};

        // 연산 - 뒤에서 부터 ver
        while (true){ // 합이 k인 부분수열 찾기 연산
            for (int i = result[0]; i <= result[1]; i++) {
                sum += sequence[i];
            }

            System.out.println("result 범위 ("+result[0] + ", " + result[1] + ") 에서 sum = " + sum);

//            if(sum < k)
            // 좌측 연산
            while (sum<k){
                result[0]--;
                sum += sequence[result[0]];
            }

            if(sum == k) break; // 종료조건
            else { // sum > k // 다시 탐색
                // 우측 범위 초기화 - 끝범위 줄임
                result[1]--;
                result[0] = result[1];
//                result[0] = result[1] - k/sequence[result[1]]; // 적어도 k/sequence[result[1]] 개 만큼은 필요
                // 코드 오류 있음
                sum = 0;
            }
        }

        System.out.println("첫번째 연산 result = "+result[0] + ", " + result[1]);

        // ver1에서 둘째 연산은 같은 숫자의 반복 [2,2,2,2,2] 이므로, 반복되는 같은 수를 찾는다.
        if(sequence[result[0]] == sequence[result[1]]){ // 둘째 연산 탐색 필요
            int sameN = sequence[result[0]];
            int leftIndex = 0;

            for (int i = result[0]-1; i >= 0 ; i--) {
//                System.out.println(i + "번째 인덱스 같다!!");
                if(sequence[i] != sameN){
                    leftIndex = i+1; // 유효한 범위
                    break;
                }
            }

            // 범위 수정
            result[1] = leftIndex + result[1] - result[0]; // 먼저 할당
            result[0] = leftIndex;
        }


        System.out.println("두번째 연산 result = "+result[0] + ", " + result[1]);
    }

    public static void main1(String[] args) { // ver2 - 실패 하나 줄임,,,아직3개 실패
        int[] sequence = {2, 2, 2, 2, 2}; // 길이 5~1,000,000
        int k =6; // 5~1,000,000,000, 항상 만들 수 있음
        // 합이 k인 부분수열 중 가장 짧은 길이 index[a,b] return, 여러개라면 앞쪽 수열 return


        // 연산용 변수
        int l = sequence.length;
        int sum=0;

        int[] result = new int[] {l-1,l-1};

        // 연산 - 뒤에서 부터 ver
        while (true){ // 합이 k인 부분수열 찾기 연산
            for (int i = result[0]; i <= result[1]; i++) {
                sum += sequence[i];
            }

            System.out.println("result 범위 ("+result[0] + ", " + result[1] + ") 에서 sum = " + sum);

//            if(sum < k)
            // 좌측 연산
            while (sum<k){
                result[0]--;
                sum += sequence[result[0]];
            }

            if(sum == k) break; // 종료조건
            else { // sum > k // 다시 탐색
                // 우측 범위 초기화 - 끝범위 줄임
                result[1]--;
                result[0] = result[1];
                sum = 0;
            }
        }

        System.out.println("첫번째 연산 result = "+result[0] + ", " + result[1]);

        // ver1에서 둘째 연산은 같은 숫자의 반복 [2,2,2,2,2] 이므로, 반복되는 같은 수를 찾는다.
        if(sequence[result[0]] == sequence[result[1]]){ // 둘째 연산 탐색 필요
            int sameN = sequence[result[0]];
            int leftIndex = 0;

            for (int i = result[0]-1; i >= 0 ; i--) {
//                System.out.println(i + "번째 인덱스 같다!!");
                if(sequence[i] != sameN){
                    leftIndex = i+1; // 유효한 범위
                    break;
                }
            }

            // 범위 수정
            result[1] = leftIndex + result[1] - result[0]; // 먼저 할당
            result[0] = leftIndex;
        }


        System.out.println("두번째 연산 result = "+result[0] + ", " + result[1]);
    }

    public static void main0(String[] args) { // Ver1 30/34 - 실패(시간 초과)
        int[] sequence = {2, 2, 2, 2, 2}; // 길이 5~1,000,000
        int k =6; // 5~1,000,000,000, 항상 만들 수 있음
        // 합이 k인 부분수열 중 가장 짧은 길이 index[a,b] return, 여러개라면 앞쪽 수열 return


        // 연산용 변수
        int l = sequence.length;
        int sum=0;

        int[] result = new int[] {l-1,l-1};

        // 연산 - 뒤에서 부터 ver
        while (true){ // 합이 k인 부분수열 찾기 연산
            for (int i = result[0]; i <= result[1]; i++) {
                sum += sequence[i];
            }

            System.out.println("result 범위 ("+result[0] + ", " + result[1] + ") 에서 sum = " + sum);

//            if(sum < k)
            // 좌측 연산
            while (sum<k){
                result[0]--;
                sum += sequence[result[0]];
            }

            if(sum == k) break; // 종료조건
            else { // sum > k // 다시 탐색
                // 우측 범위 초기화 - 끝범위 줄임
                result[1]--;
                result[0] = result[1];
                sum = 0;
            }
        }


        boolean leftFlag = true;
        if(result[0] == 0) leftFlag = false; // 줄일 수 없음 - IndexOutOfRange

        // 해당 수열이 가장 앞인지 확인하는 연산 - 같은 사이즈로 앞쪽 수열 탐색
        int[] leftResult = new int[] {result[0]-1, result[1]-1};

        while(leftFlag){
            sum = 0; // 초기화
            for (int i = leftResult[0]; i <= leftResult[1]; i++) {
                sum += sequence[i];
            }

            if(sum == k){
                // true, 다음 범위
                leftResult[0]--;
                leftResult[1]--;
                if(leftResult[0]<0){ // 탐색 끝 범위
                    break;
                }
            } else { // sum < k
                break;
            }

        }

        // leftResult 는 왼쪽으로 탐색하므로 - 답은 이전 오른쪽
        leftResult[0]++;
        leftResult[1]++;
        System.out.println("답은 leftResult = "+leftResult[0] + ", " + leftResult[1]);




//        if(leftFlag){
//            System.out.println("답은 leftResult = "+leftResult[0] + ", " + leftResult[1]);
//        }
//        else {
//            System.out.println("답은 result = "+result[0] + ", " + result[1]);
//        }


    }


}
