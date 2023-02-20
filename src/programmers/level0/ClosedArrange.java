package programmers.level0;

import java.util.ArrayList;

public class ClosedArrange { //특이한 정렬 - 특정 숫자에 가까운순서로 정렬
    private static int n;

    public static int d(int x){
        return Math.abs(x-n);
    }

    public static void main(String[] args) {
        int[] numlist = {1,2,3,4,5,6}; // 중복X
        n = 4;
        java.util.List<Integer> result = new ArrayList<>();


        int resultIndex;
        int r;
        // x를 result의 resultIndex에 할당 result.add(resultIndex, x)
        for (int x:numlist){
            resultIndex = 0; //초기화

            // result에서 x가 들어갈 resultIndex찾기!
            while(resultIndex < result.size()){
                r = result.get(resultIndex);
                // x를 r과 '순서' 비교
                if(d(x)<d(r)) break; // x가 더 가까움
                else if(d(x)>d(r)){ // x가 더 멈
                    resultIndex ++;
                    continue;
                }else if (x>r) break; // 거리가 같고 x가 더 큰 경우
                else if (x<r){ // 거리가 같고 x가 더 작은 경우 - 다음 순서 확정
                    resultIndex++;
                    break;
                }
            }
            // 할당
            result.add(resultIndex, x);
        }



        //확인
        System.out.println(result);
    }

}
