package somthingFun;

public class MapleEnhance {


    public static void main(String[] args) {
        int[] cost = {0,300,600,900,1000,1200,1300,1600,2000,3000,4000};
        int[] probability = {0,90,70,50,30,20,10,10,10,10,10};
        int costI;
        int totalCost = 0;

        for (int i = 1; i <= 10; i++) {
            costI = cost[i] * 100 / probability[i];
            totalCost += costI;
            System.out.println(i + "번째 강화");
            System.out.println("예상 비용 = " + costI + " / 총 예상비용 = " + totalCost);
            System.out.println();

        }

    }
}
