package programmers.level1;

public class MainScreenClean { // 바탕화면 정리 https://school.programmers.co.kr/learn/courses/30/lessons/161990

    public static void main(String[] args) {
        // 빈칸은 ".", 파일이 있는 칸은 "#"의 값
        String[] wallpaper = {"..", "#."}; // 직사각형


        // 조건 외 범위로 초기화
        int lux=51;
        int luy=51;
        int rdx=0;
        int rdy=0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#'){ // 파일이 있다면
                    lux = Math.min(lux,i);
                    luy = Math.min(luy,j);
                    rdx = Math.max(rdx,i+1);
                    rdy = Math.max(rdy,j+1);

                }

            }
        }

        int[] answer = {lux, luy, rdx, rdy};
        //출력 확인
        for (int i = 0; i < 4; i++) {
            System.out.println(answer[i]);
        }







    }

}
