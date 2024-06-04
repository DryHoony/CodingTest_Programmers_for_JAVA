package programmers.level1;

public class Bandage { // 붕대 감기


    public static void main(String[] args) {
        int[] bandage; // [시전 시간, 초당 회복량, 추가 회복량]
        int health; // 최대 체력 1~1000
        int[][] attacks; // [공격 시간, 피해량], 길이:1~100, 공격시간 기준 오름차순
        int result; // 답 : 남은체력 return

        // case1
//        bandage = new int[] {5,1,5};
//        health = 30;
//        attacks = new int[][] {{2,10},{9,15},{10,5},{11,5}};
//        result = 5;

        // case2
//        bandage = new int[] {3,2,7};
//        health = 20;
//        attacks = new int[][] {{1,15},{5,16},{8,6}};
//        result = -1;

        // case3
//        bandage = new int[] {4,2,7};
//        health = 20;
//        attacks = new int[][] {{1,15},{5,16},{8,6}};
//        result = -1;

        // case4
        bandage = new int[] {1,1,1};
        health = 5;
        attacks = new int[][] {{1,2},{3,2}};
        result = 3;

        Bandage obj =  new Bandage();
        int answer = obj.solution(bandage, health, attacks);
        System.out.println("답은 = " + answer + ",  정답여부 = " + (answer == result));
    }

    public int solution(int[] bandage, int health, int[][] attacks){
        int time = 0; // 현재 시간
        int timeInterval;
        int hp = health;

        // attack 을 기준으로 연산
        // attack 을 받을 때마다, 체력 확인 >> 음수면 return -1
        for(int[] attack:attacks){
            timeInterval = attack[0] - time -1; // 공격 당하는 시점에선 회복 X
            hp += (timeInterval/bandage[0])*bandage[2]; // 사이클 회복
//            System.out.println("timeInterval%bandage[0] = " + timeInterval%bandage[0]);
            hp += timeInterval*bandage[1]; // 초당 회복
            hp = Math.min(health, hp); // 최대체력 초과 X

            // 출력확인
            System.out.println();
//            System.out.println(attack[0] + "초 연산");
//            System.out.println("timeInterval = " + timeInterval);
//            System.out.println("bandage[0] = " + bandage[0]);
//            System.out.println("bandage[2] = " + bandage[2]);
//            System.out.println("bandage[1] = " + bandage[1]);

            // 공격받음
            hp -= attack[1];
            if(hp <= 0) return -1;

            // 다음 attack 준비
            time = attack[0];

            // 출력확인
            System.out.println(attack[0] + "초에 체력 = " + hp);
        }

        System.out.println();
        return hp;
    }
}
