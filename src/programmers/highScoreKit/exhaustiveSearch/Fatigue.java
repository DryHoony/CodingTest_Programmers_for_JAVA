package programmers.highScoreKit.exhaustiveSearch;

public class Fatigue { // 피로도 - 다시다시!!

    static int count=0;
    static int max=0;

    static int k = 80; // 남은 피로도
    static int[][] dungeons = {{80,20},{50,40},{30,10}}; // [최소필요 피로도, 소모 피로도], 1~8개

    public static void main(String[] args) {
//        int k = 80; // 남은 피로도
//        int[][] dungeons = {{80,20},{50,40},{30,10}}; // [최소필요 피로도, 소모 피로도], 1~8개
        // 탐험할 수 있는 최대 던전 수 return
//        int count = 0; // main 메소드 밖 static 으로 구성

        // 2차원 정렬 ver1 - 피로도가 낮은 순으로 정렬, 최소필요 필요도가 같으면 소모 피로도가 낮은 값이 우선 >> 반례!! 문제예시
//        Arrays.sort(dungeons, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]){
//                    return o1[1] - o2[1]; // 오름차순
//                }
//                return o1[0] - o2[0]; // 오름차순
//            }
//        });

        // 2차원 정렬 ver2 - '소모 피로도'가 낮은것 먼저 그 중에서 '필요 피로도'는 높은것 먼저 >> 반례! 문제예시
//        Arrays.sort(dungeons, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1] == o2[1]){
//                    return o2[0] - o1[0]; // '필요 피로도' 는 높은것 우선
//                }
//                return o1[1] - o2[1]; // '소모 피로도' 낮은것 우선
//            }
//        });

        // 2차원 정렬 ver3 - '필요 피로도' 높은것 우선 그 중에서 '소모 피로도' 낮은것 우선
//        Arrays.sort(dungeons, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1] - o2[1]; // '필요 피로도' 같을 때는 '소모 피로도' 낮은것 우선
//                }
//                return o2[0] - o1[0]; // '필요 피로도' 높은것 우선
//            }
//        });

        // '필요' '소모' 각각의 기준으로 보면 정렬의 의미가 안보인다. 둘의 차이로 계산해 보자
        // 계산 하기도 전에 반례 >> k=100, (100,95) (10,10) (10,10) (10,10)
        // 차이가 크다고 항상 우선인 것도 아닌것 같다

        // 정렬 완료된 던전 연산
//        for(int[] d:dungeons){
//            if(k >= d[0]){
//                k -= d[1];
//                count++;
//            }else break;
//        }

        // Brute-Force 이용 - dungeons.length <= 8 이므로 최대 8!(40320) 가짓수의 정렬에 대해 연산을 시행


        int[] index = new int[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            index[i] = i;
        }


        // 재귀문 안에서 순열돌림 - 각각의 case 순서로 피로도 '연산' 돌림
//        permutation(index, 0, dungeons.length, dungeons.length);


//        System.out.println(max);
    }

    static void permutation(int[] arr, int depth, int n, int r){
        // 재귀함수를 이용한다.
        if (depth == r){ // 종료조건
            // arr 출력 >> 출력 대신 arr 의 index 순서로 '연산' 시행
            count = 0; // 초기화

            for(int i:arr){
                if(k >= dungeons[i][0]){
                    k -= dungeons[i][1];
                    count++;
                    System.out.print(i + " ");
                }
                else break;
            }
            System.out.println("순서로 던전 돈 결과 >> "+ count + "개 던전 돌았음");
            System.out.println();

            if(count>max) max = count;
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n, r);
            swap(arr, depth, i);
            // swap한 케이스에 대해 재귀로 돌리고, 다른 swap연산을 하기 위해 원상복구
        }

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
