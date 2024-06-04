package somthingFun.GeunwooMetroProblem;

public class GeunwooMetroProblem1 { // 근우 지하철 문제
//    <근우 지하철>
//    정방 1km 구역에 균일한 밀도의 인구가 분포해있다. 지하철의 속도는 걷는속도의 100배. >> 전철은 거리 그대로, 지하철은 거리/100 으로 할당
//    2km 거리의 비선형 지하철을 설치할때 가장 효율적인 노선의 형태는?
//    minimize(임의의 점에서 임의의 점까지 이동시간의 평균)

    static float[][] space;

    public static void main(String[] args) {
        int[] startPoint; // 출발 위치
        int[] targetPoint; // 도착 위치

        int size = 1000; // 공간 크기
        space = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                space[i][j] = trainApproachDistance(new int[]{i,j});
            }
        }





    }

    public static float trainApproachDistance(int[] startPoint){ // X 모양 전철까지 거리
        float distance; // 전철까지 대각선 거리

        if( (startPoint[0]<500 && startPoint[1]>=500) || (startPoint[0]>=500 && startPoint[1]<500) ){ // 1,3 사분면 -> x+y-999=0 대각선
            distance = (float) (Math.abs(startPoint[0]+startPoint[0]-999) / Math.sqrt(2));
        }
        else{ // 2,4 사분면 -> x-y=0 대각선
            distance = (float) (Math.abs(startPoint[0]-startPoint[0]) / Math.sqrt(2));
        }
        return distance;
    }

    public static float straightDistanceTime(int[] startPoint, int[] targetPoint){
//        float distance = (float) Math.sqrt(Math.pow(startPoint[0]-targetPoint[0],2) + Math.pow(startPoint[1]-targetPoint[1],2));
//        return distance;
        return (float) Math.sqrt(Math.pow(startPoint[0]-targetPoint[0],2) + Math.pow(startPoint[1]-targetPoint[1],2));
    }

    public static float trainShapeX1(int[] startPoint, int[] targetPoint){ // 전철 길이제한 적용X, X Shape 으로 대각선 끝까지 할당
        float walkTime = straightDistanceTime(startPoint, targetPoint); // 걷는 시간
        float totalTimeSpend = 0;

        float startD1; // 출발점 대각선 거리
        float[] startProjection = new float[2]; // 출발점 대각선 수선의 발
        float targetD1; // 도착점 대각선 거리
        float[] targetProjection = new float[2]; // 도착점 대각선 수선의 발
        float trainD1; // 전철 거리;



        // 출발점에서 대각선까지 거리, 대각선 수선의 발
        if( (startPoint[0]<500 && startPoint[1]>=500) || (startPoint[0]>=500 && startPoint[1]<500) ){ // 1,3 사분면 -> x+y-999=0 대각선
            startD1 = (float) (Math.abs(startPoint[0]+startPoint[0]-999) / Math.sqrt(2));
            startProjection[0] = (999 + startPoint[0] - startPoint[1]) / 2;
            startProjection[1] = (999 - startPoint[1] + startPoint[0]) / 2;

        }
        else{ // 2,4 사분면 -> x-y=0 대각선
            startD1 = (float) (Math.abs(startPoint[0]-startPoint[0]) / Math.sqrt(2));
            startProjection[0] = (startPoint[0] + startPoint[1]) / 2;
            startProjection[1] = (startPoint[0] + startPoint[1]) / 2;
        }

        totalTimeSpend += startD1;
        if(totalTimeSpend > walkTime) return walkTime; // 걷는게 더 빠르면 걷기로

        // 도착점에서 대각선까지 거리, 대각선 수선의 발
        if( (targetPoint[0]<500 && targetPoint[1]>=500) || (targetPoint[0]>=500 && targetPoint[1]<500) ){ // 1,3 사분면 -> x+y-999=0 대각선
            targetD1 = (float) (Math.abs(targetPoint[0]+targetPoint[0]-999) / Math.sqrt(2));
            targetProjection[0] = (999 + targetPoint[0] - targetPoint[1]) / 2;
            targetProjection[1] = (999 - targetPoint[1] + targetPoint[0]) / 2;
        }
        else{ // 2,4 사분면 -> x-y=0 대각선
            targetD1 = (float) (Math.abs(targetPoint[0]-targetPoint[0]) / Math.sqrt(2));
            targetProjection[0] = (targetPoint[0] + targetPoint[1]) / 2;
            targetProjection[1] = (targetPoint[0] + targetPoint[1]) / 2;
        }

        totalTimeSpend += targetD1;
        if(totalTimeSpend > walkTime) return walkTime; // 걷는게 더 빠르면 걷기로

        // 전철 내부 거리 연산 -> 생략 ver


        System.out.println("X 모양 결과 = " +totalTimeSpend);
        return totalTimeSpend;
    }

    public static float trainShapeX2(int[] startPoint, int[] targetPoint){ // 전철 길이제한 2km, 각 대각선 길이를 1km로 제한
        float totalTimeSpend = 0;
        // 전철 거리 연산

        System.out.println("X 모양 결과 = " +totalTimeSpend);
        return totalTimeSpend;
    }

    public static float trainShapeO(int[] startPoint, int[] targetPoint){
        float totalTimeSpend = 0;


        System.out.println("원 모양 결과 = " + totalTimeSpend);
        return totalTimeSpend;
    }
}
