package programmers.level3;

import java.util.ArrayList;

public class OptimumMatrixMultiple { // 최적의 행렬 곱셈

    public static void main(String[] args) {

        int[][] matrix_sizes;
        int result;

        // 예시1
        matrix_sizes = new int[][]{{5,3},{3,10},{10,6}}; // 갯수 3~200
        result = 270;

//        // 예시2 (직접만듬)
        matrix_sizes = new int[][]{{2,2},{2,3},{3,4},{4,5}};
        result = 110;
//
//        // 예시3 (직접만듬)
        matrix_sizes = new int[][]{{1,9},{9,10},{10,8},{8,1}};
        result = 800;

//        // 예시4 (직접만듬)
        matrix_sizes = new int[][]{{1,8},{8,3},{3,5},{5,8},{8,1}};
        result = 82;


        // [a,b] * [b,c] 연산의 곱셈횟수 = a*b*c >> 즉 b가 큰 순서로 진행하는 것이 유리
        System.out.println("답은 = " + solution(matrix_sizes));
    }

    // ver1
    public static int solution(int[][] matrix_sizes){
        int answer = 0;
        int left = matrix_sizes[0][0];
        int right = matrix_sizes[matrix_sizes.length - 1][1];
        System.out.println("left = " + left);
        System.out.println("right = " + right);

        ArrayList<Integer> mat = new ArrayList<>(); // mat 에 숫자만 할당
        ArrayList<Integer> mat2 = new ArrayList<>(mat); // (정렬) 순서 연산용 mat2

//        mat.add(matrix_sizes[0][0]);
//        mat2.add(matrix_sizes[0][0]);
//        for(int[] m:matrix_sizes){
//            mat.add(m[1]);
//            mat2.add(m[1]);
//            System.out.println(m[1] + "추가");
//        }
//        mat.remove(mat.size()-1);
//        mat2.remove(mat.size()-1);

        for (int i = 0; i < matrix_sizes.length-1; i++) {
            mat.add(matrix_sizes[i][1]);
            mat2.add(matrix_sizes[i][1]);
        }

        // mat2 내림차순 정렬
        mat2.sort((a,b)->b-a);
        System.out.println("mat2 = " + mat2);

        // mat2 순서대로 mat 에서 제거하면서 곱셈횟수 계산
        for(int m:mat2){
            if(mat.size() <= 2) break; // mat 가 2개 남으면 더이상 반복연산X (앞뒤값이 없음)

            int idx = mat.indexOf(m);
            int nowLeft;
            int nowRight;

            if(idx == 0){
                nowLeft = left;
                nowRight = mat.get(idx+1);
            } else if (idx == mat.size()-1) {
                nowLeft = mat.get(idx-1);
                nowRight = right;
            }else{
                nowLeft = mat.get(idx-1);
                nowRight = mat.get(idx+1);
            }

            answer += nowLeft * m * nowRight;
            System.out.println("answer += " + nowLeft + " * " + m + " * " + nowRight + " = " + nowLeft*m*nowRight);
            mat.remove(idx);

        }

        // mat 가 2개 남았을때 연산
        int a = mat.get(0);
        int b = mat.get(1);
        if(a >= b){
            answer += left*a*b + left*b*right;
            System.out.println("answer += " + left + " * " + a + " * " + b + " + " + left + " * " + b + " * " + right + " = " + (left*a*b + left*b*right));
        }
        else{
            answer += a*b*right + left*a*right;
            System.out.println("answer += " + a + " * " + b + " * " + right + " + " + left + " * " + a + " * " + right + " = " + (a*b*right + left*a*right));
        }


        return answer;
    }

}
