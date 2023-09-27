package somthingFun;

import java.util.HashMap;
import java.util.Map;

public class AccuracyRate { // 명중률
    // 아르테일 - 전사 명중률 계산

    static Map<String, int[]> monster = new HashMap<>();

    public static void main(String[] args) {

        // 이름 [레벨, 회피율]
//        Map<String, int[]> monster = new HashMap<>();
        monster.put("초록버섯", new int[] {15,5});
        monster.put("파란버섯", new int[] {20,7});
        monster.put("뿔버섯", new int[] {22,7});
        monster.put("좀비버섯", new int[] {24,8});
        monster.put("와일드보어", new int[] {25,8});


        // input
        int myLevel = 20;
//        String monsterName = "초록버섯";

        f(myLevel, "초록버섯");
        f(myLevel, "파란버섯");
        f(myLevel, "뿔버섯");



    }

    public static void f(int myLevel, String monsterName){
        System.out.print(myLevel+ "레벨 " + monsterName + " 필요 명중률 >> ");
        if(myLevel >= monster.get(monsterName)[0]){
            // 캐릭터 레벨이 몬스터 레벨보다 같거나 높을때
            double needAccuracy = monster.get(monsterName)[1] * 3.6666;
            System.out.println("캐릭터가 레벨 같거나 높다 >> "+ needAccuracy);

        }
        else{
            // 캐릭터 레벨이 몬스터 레벨보다 낮을 때
            double needAccuracy = ((monster.get(monsterName)[0]-myLevel)*2+55) * monster.get(monsterName)[1];
            System.out.println("캐릭터 레벨이 더 낮다 >> " + needAccuracy);
            System.out.println(monsterName+"의 레벨은 "+monster.get(monsterName)[0]);
        }


    }
}
