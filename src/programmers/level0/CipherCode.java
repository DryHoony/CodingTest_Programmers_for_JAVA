package programmers.level0;

public class CipherCode { // 암호해독


    public static void main(String[] args) {
        String cipher = "dfjardstddetckdaccccdegk";
        int code = 4; // chpher를 4칸마다 잘라 암호해독

        String answer = "";

        for(int i=code; i<=cipher.length(); i+=code){
            answer += cipher.substring(i-1,i);
        }

        System.out.println(answer);



    }
}
