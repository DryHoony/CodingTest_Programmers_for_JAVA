package programmers.level2;

public class SoloPlayingMaster { // 혼자 놀기의 달인

    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4}; // 길이 2~100, 값은 길이 이하의 자연수, 중복X

        // 1~n 개의 카드가 무작위 배열
        // 그룹연산 - 첫 상자뽑 (임의) - 상자속 카드숫자에 해당하는 상자뽑 - 순환 고리 나올때 까지 반복
        // 1그룹연산 에서 전체 순회하면 return 0;
        // else return Max(1그룹수 * 2그룹수);


        // 연산용 변수
        int n = cards.length;
        int index; // 연산 index
        int count; // 그룹 count
        boolean visited[] = new boolean[n]; // 초기값 false;


        // 1 그룹연산 - 전체 순환일경우 조기 종료 (return 0;)
        index=0; // 출발
        count=0;
        while (!visited[index]){ // 순환고리 만들어질 때까지
            count++;
            visited[index] = true;

            // 다음
            index = cards[index]-1;
        }

        if(count == n){
//            return 0;
            System.out.println("1그룹연산 조기종료!!");
        }
        int max1 = count;
        int max2 = 0;

        // 계속 연산
        while(true){
            index = 0; // 초기화
            for (int i = 1; i < n; i++) {
                if(visited[i] == false){
                    index = i;
                    break;
                }
            }
            if(index == 0) break; // 종료조건 - 전부 그룹순회 완료
            count = 0; // 초기화

            // 그룹연산 - 순환고리
            while (!visited[index]){ // 순환고리 만들어질 때까지
                count++;
                visited[index] = true;

                // 다음
                index = cards[index]-1;
            }

            // 최대값 업데이트
            if(count > max2){
                if(count > max1){
                    max2 = max1;
                    max1 = count;
                }
                else max2 = count;
            }
//            System.out.println("count = " + count);
//            System.out.println("max1 = " + max1);
//            System.out.println("max2 = " + max2);

        }





        System.out.println("답은 = " + max1*max2);
    }
}
