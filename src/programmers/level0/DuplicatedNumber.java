package programmers.level0;

public class DuplicatedNumber { // 중복된 숫자 개수

    public int solution(int[] array, int n){
        int answer = 0;

        for(int i:array){
            if(i==n){
                answer+=1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println("출력");
    }

}
