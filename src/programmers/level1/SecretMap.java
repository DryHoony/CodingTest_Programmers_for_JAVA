package programmers.level1;

public class SecretMap { // 비밀지도, 카카오 기출 https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=java

    public static String[] mapReading(int n, int[] arr1, int[] arr2){
        String[] answer = new String[n];
        String a1, a2, a;

        for (int i = 0; i < n; i++) {
            // arr1[i], 와 arr2[i]를 이진수 변환
            a1 = Integer.toBinaryString(arr1[i]);
            a1 = "0".repeat(n-a1.length()) + a1; // 길이 n맞춤
            a2 = Integer.toBinaryString(arr2[i]);
            a2 = "0".repeat(n-a2.length()) + a2; // 길이 n맞춤

            // 변환된 이진수를 합침 - 둘다0일때만 공백, else #
            a = "";
            for (int j = 0; j < n; j++) {
                if(a1.charAt(j)=='1' || a2.charAt(j)=='1'){ // 둘중하나가 벽이면 #
                    a += "#";
                }else a += " "; // 아님 공백
            }

            // 해당 문자열을 answer[i]에 할당
            answer[i] = a;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};

        // 비밀지도 해독연산
        String[] answer = mapReading(n,arr1,arr2);
        for (String s:answer){
            System.out.println(s);
        }





    }

}

