import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        // 연산용 변수
//        List<int[]> jointArray = new ArrayList<>(); // 교점 저장
        Set<int []> jointSet = new HashSet<>(); // 중복제거
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        // 교점 연산 - jointSet 에 기록
        for (int i = 0; i < line.length-1; i++) {
            for (int j = i+1; j < line.length; j++) {
//                System.out.println(i + "번째와 " + j + "번째 연산");

                if(checkTwoLine(line[i], line[j])){
                    int[] joint = calculateJoint(line[i], line[j]);
                    System.out.println("교점 = (" + joint[0] + ", " + joint[1] + ")");
                    jointSet.add(joint);

                    // 범위 설정
                    // if() - else if() 로 설정했다가 초기값에서 min 밖에 설정안됨 (max 는 여전히 MIN_VAL) >> 예시 1번 범위 오류
                    if(joint[0] < minX){
                        minX = joint[0];
                    }
                    if(joint[0] > maxX){
                        maxX = joint[0];
                    }

                    if(joint[1] < minY){
                        minY = joint[1];
                    }
                    if(joint[1] > maxY){
                        maxY = joint[1];
                    }

                }
            }
        }

        // isStartPointArr 연산 - 복잡도를 줄이기 위해 Boolean 타입으로 교점을 표현
        System.out.println("x 범위 " + minX +"~" + maxX);
        System.out.println("y 범위 " + minY +"~" + maxY);
        boolean[][] isStartPointArr = new boolean[maxY - minY + 1][maxX - minX + 1]; // 연산용
        int len = isStartPointArr.length;

        for(int[] star : jointSet){
//            System.out.println(star[0] + ", " + star[1]);
            isStartPointArr[star[1] - minY][star[0] - minX] = true;
        }

        // String[] 타입으로 바꾸기 - isStarPointArr >> answer
        String starLine;
        String[] answer = new String[len];

        for (int i = 0; i < isStartPointArr.length; i++) {
            starLine = ""; // 초기화
            boolean[] booleanArr = isStartPointArr[i];

            for(boolean isStar : booleanArr){
                if(isStar) starLine += "*";
                else starLine += ".";
            }

            answer[len-i-1] = starLine;
            System.out.println(starLine);
        }


    }

    // 두 직선의 교점이 유일하게 존재하는지 확인
    public static boolean checkTwoLine(int[] l1, int[] l2){
        if(l1[0]*l2[1] - l1[1]*l2[0] == 0) return false; // 두직선은 평행

        if((l1[1]*l2[2] - l1[2]*l2[1]) % (l1[0]*l2[1] - l1[1]*l2[0]) == 0){
            if((l1[2]*l2[0] - l1[0]*l2[2]) % (l1[0]*l2[1] - l1[1]*l2[0]) == 0) return true;
        }

        return false;
    }

    public static int[] calculateJoint(int[] l1, int[] l2){
        int[] joint = new int[2];

        joint[0] = (l1[1]*l2[2] - l1[2]*l2[1]) / (l1[0]*l2[1] - l1[1]*l2[0]);
        joint[1] = (l1[2]*l2[0] - l1[0]*l2[2]) / (l1[0]*l2[1] - l1[1]*l2[0]);

        return joint;
    }

}
