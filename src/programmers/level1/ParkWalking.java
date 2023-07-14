package programmers.level1;

public class ParkWalking { // 공원산책
    // https://school.programmers.co.kr/learn/courses/30/lessons/172928

    // ver1 - 5/20
//    public static void main(String[] args) { // 런타임 에러!!!
//
//        String[] park = {"SOO","OOO","OOO"}; // 공원 3~50 * 3~50
//        String[] routes = {"E 2","S 2","W 1"}; // 1~50
//
//        int[] answer = {0,0}; // {세로, 가로}
//        int h = park.length; // 세로
//        int w = park[0].length(); // 가로
//
//        String line;
//        boolean flag = false;
//        //초기위치 'S'설정
//        for (int i = 0; i < h; i++) {
//            line = park[i];
//            for (int j = 0; j < w; j++) {
//                if(line.charAt(j) == 'S'){
//                    answer[0] = i;
//                    answer[1] = j;
//                    flag = true;
//                }
//            }
//            if(flag){
//                break;
//            }
//        }
//
//        boolean obstacle;
//        char direction;
//        int l;
//        for(String route:routes){ // 연산
//
//            direction = route.charAt(0);
//            l = Integer.parseInt(String.valueOf(route.charAt(2))); // 타입확인
//            route.split(" ");
////            l = Integer.parseInt(route.substring(2,3)); // 별 차이 없음
//            obstacle = false; // 초기화
//
//            if(direction == 'E' && answer[1]+l < w){ // 오른쪽
//                // 장애물 확인
//                line = park[answer[0]];
//                if(line.substring(answer[1]+1, answer[1]+1+l).contains("X")){
//                    obstacle = true;
//                }
//                if(!obstacle){ // 장애물 없으면 이동
//                    answer[1] += l;
//                }
//
//            } else if (direction == 'W' && answer[1]- l >= 0) { // 왼쪽
//                // 장애물 확인
//                line = park[answer[0]];
//                if(line.substring(answer[1]-l, answer[1]).contains("X")){
//                    obstacle = true;
//                }
//                if (!obstacle){
//                    answer[1] -= l;
//                }
//
//            } else if (direction == 'S' && answer[0]+l < h) { // 아래
//                // 장애물 확인
//                for (int i = answer[0]+1; i <= answer[0]+l; i++) {
//                    if (park[i].charAt(answer[1]) == 'X'){
//                        obstacle = true;
//                        break;
//                    }
//                }
//                if(!obstacle){
//                    answer[0] += l;
//                }
//
//            } else if (direction == 'N' && answer[0]-l >= 0) { // 위쪽
//                // 장애물 확인
//                for (int i = answer[0]-1; i >= answer[0]-l; i--) {
//                    if (park[i].charAt(answer[1]) == 'X'){
//                        obstacle = true;
//                        break;
//                    }
//                    if(!obstacle){
//                        answer[0] -=l;
//                    }
//                }
//            }
//
//        }
//
//        System.out.println(answer[0]);
//        System.out.println(answer[1]);
//
//
//    }

    // ver2
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"}; // 공원 3~50 * 3~50, X는 장애물
        String[] routes = {"E 2","S 2","W 1"}; // 1~50

        int h = park.length;
        int w = park[0].length();
        String line;
        int[] answer = {0,0};
        // 초기위치
        for (int i = 0; i < h; i++) {
            line = park[i];
            if(line.contains("S")){
                answer[0] = i; // 행
                answer[1] = line.indexOf("S"); // 열
                break;
            }
        }


//        String[] order = routes[0].split(" "); //Integer.parseInt(order[1])
        String[] order;


    }

    public static boolean obstacleCheck(String[] park, int[] answer){
        // 현재 위치 장애물X 체크

        return true;
    }


}
