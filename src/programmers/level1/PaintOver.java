package programmers.level1;

public class PaintOver { // 덧칠하기

    // ver1
    public static void main(String[] args) {
        int n = 8; // 1미터 길이의 구역 갯수 1~100,000
        int m = 4; // 롤러의 길이 1~100,000
        int[] section = {2,3,6}; // (반드시) 칠해야 할 구역, 중복가능, 적어도 한번
        int answer = 0; // 페인트 칠해야 하는 최소 횟수

        // 롤러 사용시 양끝
        int s=0; // start
        int e=0; // end

        for(int x:section){
            if(x<=e){ // x가 이전 롤러 범위에 포함
                continue;
            }
            else{ // x 새로운 롤러질
                answer++; // 롤럴질 횟수++
                s = x;
                e = x+m-1; // 간격주의
            }
        }

        System.out.println(answer);
    }
}
