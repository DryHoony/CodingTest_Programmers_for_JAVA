package somthingFun;

import java.util.Random;

public class ThreeGunner {
    // 세 명의 총잡이
    // https://namu.wiki/w/%EC%84%B8%20%EB%AA%85%EC%9D%98%20%EC%B4%9D%EC%9E%A1%EC%9D%B4


    public static String game(){
        // 명중률
        float W = 0.3f; // 화이트
        float G = 0.7f; // 그레이
        float B = 1; // 블랙
        Random random = new Random();

        // 생존
        boolean wAlive = true;
        boolean gAlive = true;
        boolean bAlive = true;

        while(true){

            if(wAlive){ // W 차례
                if(gAlive && bAlive){ // 셋 모두 생존
                    // 허공발포
                } else { // 둘만 생존 - 누가됬든 발포 30%
                    if(random.nextFloat() <= W){
                        return "W"; // 우승
                    }
                }
            }


            if(gAlive){ // G 차례
                if(wAlive && bAlive){ // 셋 모두 생존
                    if(random.nextFloat() <= G){
                        bAlive = false; // B에게 발포 70%
                    }
                }else { // 둘만 생존 - 누가됬든 발포 70%
                    if(random.nextFloat() <= G){
                        return "G"; // 우승
                    }
                }
            }

            if(bAlive){ // B 차례
                if(wAlive && gAlive){ // 셋 모두 생존
                    gAlive = false; // G에게 발포 100%
                }else { // 둘만 생존 - 누가됬든 발포 100%
                    return "B";
                }

            }
        }

    }

    public static void tryGame(int gameCount){
        int wWin = 0;
        int gWin = 0;
        int bWin = 0;
        String winner;

        for (int i = 0; i < gameCount; i++) {
            winner = game();
            if(winner.equals("W")){
                wWin++;
            } else if (winner.equals("G")) {
                gWin++;
            } else if (winner.equals("B")) {
                bWin++;
            }
        }

        System.out.println(gameCount+"번 시도");
        System.out.println("화이트 생존률 = " + (float)wWin/gameCount);
        System.out.println("그레이 생존률 = " + (float)gWin/gameCount);
        System.out.println("블랙 생존률 = " + (float)bWin/gameCount);
        System.out.println("----------------------------");
    }


    public static void main(String[] args) {

        // 명중률
        float W = 0.3f; // 화이트
        float G = 0.7f; // 그레이
        float B = 1; // 블랙


//        Random random = new Random();
//        System.out.println(random.nextFloat());
        // 확률 test
//        int GCount = 0;
//        int WCount = 0;
//        int testCount=100;
//        for (int i = 0; i < testCount; i++) {
//            if(random.nextFloat() <= G)
//                GCount++;
//            if(random.nextFloat() <= W)
//                WCount++;
//        }
//        System.out.println(testCount+"번 시도 >> G:"+GCount + "   W:"+WCount);


        // 순서는 WGB (낮은 확률부터)
        // W전략 - GB 모두 생존시 허공으로 발포, GB 중 한명만 남으면 발포
        // BG 전략 - 명중률이 높은 인원에게 (우선)발포


        // 정답 - 화이트 35.58%, 그레이 43.42%, 블랙 21%
        tryGame(10);
        tryGame(100);
        tryGame(100);
        tryGame(1000);
        tryGame(10000);
        tryGame(100000);





    }

}
