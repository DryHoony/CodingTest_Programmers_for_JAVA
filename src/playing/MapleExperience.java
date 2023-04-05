package playing;

public class MapleExperience { // 메이플 경험치 연산

    // 필요경험치 - Index 숫자가 해당 레벨 필요경험치(Lv120 까지, https://maplekibun.tistory.com/101)
    static int[] experienceRequired = {0,15,34,57,92,135,372,560,840,1242,1716,2360,3216,4200,5460,7050,8840,11040,13716,16680,20216,
    24402,28980,34320,40512,47216,54900,63666,73080,83720,95700,108480,122760,138666,155540,174216,194832,216600,240500,266682,294216
    ,324240,356916,391160,428280,468450,510420,555680,604416,655200,709716,748608,789631,832902,878545,926689,977471,1031036,1087536,1147132,1209994,
    1276301,1346242,1420016,1497832,1579913,1666492,1757815,1854143,1955750,2062925,2175973,2295216,2420993,2553663,2693603,2841212,2996910,3161140,3334370,3517093,
    3709829,3913127,4127566,4353756,4592341,4844001,5109452,5389449,5684790,5996316,6324914,6671519,7037118,7422752,7829518,8258575,8711144,9188514,9692044,10223168,
    10783397,11374327,11997640,12655110,13348610,14080113,14851703,15665576,16524049,17429566,18384706,19392187,20454878,21575805,22758159,24005306,25320796,26708375,28171993,29715818};





    public static void main(String[] args) {

        int nowLevel = 40; // 현재 레벨
        int exExchange = 217340; // 와이번 전리품 경험치
        // 한칸(9999개)당 10000/200 = 50번으로 연산


        // 목표레벨에 따른 필요 전리품 갯수
        int targetLevel = 70;
        // 현재 레벨에서 목표레벨 까지
        int needEX=0;
        for (int i = nowLevel; i < targetLevel; i++) {
            needEX += experienceRequired[i];
        }

        int count = needEX/exExchange + 1;
        System.out.println("현재 레벨" + nowLevel + "에서 목표 래벨" + targetLevel + "까지 '" + count + "'번의 전리품 교환이 필요");
        float itemNedd = count*200;
        itemNedd /= 9999;
        System.out.println(itemNedd + "칸 만큼의 전리품이 필요");
        System.out.println();


        // 현재 전리품 갯수에 따른 도달 레벨
        float itemGet = (float) 1.15; // 전리품 '칸' 수로 계산

        int experienceGet = (int)itemGet*50; // 한칸당 갯수는 10000(9999)개 >> 10000/200 = 50번 만큼 교환가능
        experienceGet *= exExchange;

        while(experienceGet > experienceRequired[nowLevel]){
            experienceGet -= experienceRequired[nowLevel];
            nowLevel ++;
        }
        System.out.println("현재 전리품 " + itemGet + "칸으로 " + nowLevel + "까지 레벨 업");












    }

}
