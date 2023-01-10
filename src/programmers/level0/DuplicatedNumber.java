package programmers.level0;

public class DuplicatedNumber {

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
