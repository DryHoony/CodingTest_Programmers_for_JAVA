import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

    // 두 직선의 교점이 유일하게 존재하는지 확인
    public static boolean checkTwoLine(int[] l1, int[] l2){
        if((long)l1[0]*l2[1] - (long)l1[1]*l2[0] == 0) return false; // 두직선은 평행

        if(((long)l1[1]*l2[2] - (long)l1[2]*l2[1]) % ((long)l1[0]*l2[1] - (long)l1[1]*l2[0]) == 0){
            if(((long)l1[2]*l2[0] - (long)l1[0]*l2[2]) % ((long)l1[0]*l2[1] - (long)l1[1]*l2[0]) == 0) return true;
        }

        return false;
    }

    public static int[] calculateJoint(int[] l1, int[] l2){
        int[] joint = new int[2];

        joint[0] = (int) (((long)l1[1]*l2[2] - (long)l1[2]*l2[1]) / ((long)l1[0]*l2[1] - (long)l1[1]*l2[0]));
        joint[1] = (int) (((long)l1[2]*l2[0] - (long)l1[0]*l2[2]) / ((long)l1[0]*l2[1] - (long)l1[1]*l2[0]));

        return joint;
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        // 길이 2~1000, 값 -100,000 ~ 100,000 이하 정수
        // "Ax + By + C = 0" 에서 계수 ABC 값
        // 교점중 정수는 * 로 표현, 나머지는 . 로 표현
        // 별을 포함하는 최소 크기로 표현된 String[] return
        // 정답은 1000*1000 크기 이내에서 표현됨
        // 연산 과정중 계수의 곱은 최대 10^10 >> int 의 범위 2*10^9 을 넘어감 >> long 타입 필요!


        // 연산용 변수









    }




}
