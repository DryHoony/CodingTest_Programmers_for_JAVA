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
//    public static void main(String[] args) {
//        String[] park = {"SOO", "OOO", "OOO"}; // 공원 3~50 * 3~50, X는 장애물
//        String[] routes = {"E 2", "S 2", "W 1"}; // 1~50
//
//        int h = park.length;
//        int w = park[0].length();
//        String line;
//        int[] answer = {0, 0}; // 위치
//        // 초기위치
//        for (int i = 0; i < h; i++) {
//            line = park[i];
//            if (line.contains("S")) {
//                answer[0] = i; // 행
//                answer[1] = line.indexOf("S"); // 열
//                break;
//            }
//        }
//
//
//        int l;
//        boolean flag;
////        String[] order = routes[0].split(" "); //Integer.parseInt(order[1])
//        String[] order;
//
//        for (String r : routes) {
//            order = r.split(" "); // {방향, 거리}
//            l = Integer.parseInt(order[1]); // 움직인 거리
//
//            if (order[0].equals("E") && answer[1] + l < w) { // 동
//                line = park[answer[0]];
////                line.substring(answer[1] + 1, answer[1] + l+1); // 인덱스 확인 ok
//                if (!line.substring(answer[1] + 1, answer[1] + l + 1).contains("X")) {
//                    // 장애물을 포함하지 않으면 ㄱㄱ
//                    answer[1] += l;
//                }
//
//            } else if (order[0].equals("W") && answer[1] - l >= 0) { // 서
//                line = park[answer[0]];
//                if (!line.substring(answer[1] - l, answer[1]).contains("X")) {
//                    answer[1] -= l;
//                }
//
//            } else if (order[0].equals("S") && answer[0] + l < h) { // 남 - park[i] 인덱스 증가
//                // 한줄한줄 모두 확인
//                flag = true;
//                for (int i = answer[0] + 1; i <= answer[0] + l; i++) {
//                    if (park[i].charAt(answer[1]) == 'X') {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    answer[0] += l;
//                }
//
//            } else if (order[0].equals("N") && answer[0] - l >= 0) { // 북 - park[i] 인덱스 감소
//                // 한줄한줄 모두 확인
//                flag = true;
//                for (int i = answer[0] - 1; i >= answer[0] - l; i--) {
//                    if (park[i].charAt(answer[1]) == 'X') {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    answer[0] += l;
//                }
//
//            }
//
//        }
//
//
//        // 출력
//        System.out.println("위치 출력 >> "+answer[0]+", "+answer[1]);
//    }


    // ver3 - 세로(행)버전 line 따로 구해두고 출력으로 사용
    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"}; // 공원 3~50 * 3~50, X는 장애물
//        String[] park = {"SOO","OXX","OOO"};
//        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2", "S 2", "W 1"}; // 1~50

        int h = park.length;
        int w = park[0].length();

        String[] symmetryPark = new String[w];
        for (int i = 0; i < w; i++) {
            symmetryPark[i] = "";
        }

        for(String line:park){
            int i=0;
            for(String x:line.split("")){
                symmetryPark[i]+=x;
                i++;
            }
        }
        // 대칭park 값 확인 ok


        String line;
        int[] answer = {0,0}; // {세로, 가로}
        // 초기위치
        for (int i = 0; i < h; i++) {
            line = park[i];
            if (line.contains("S")) {
                answer[0] = i; // 행
                answer[1] = line.indexOf("S"); // 열
                break;
            }
        }


        int l;
        boolean flag;
//        String[] order = routes[0].split(" "); //Integer.parseInt(order[1])
        String[] order;

        for (String r : routes) {
            order = r.split(" "); // {방향, 거리}
            l = Integer.parseInt(order[1]); // 움직인 거리

            if (order[0].equals("E") && answer[1] + l < w) { // 동
                line = park[answer[0]];
//                line.substring(answer[1] + 1, answer[1] + l+1); // 인덱스 확인 ok
                if (!line.substring(answer[1] + 1, answer[1] + l + 1).contains("X")) {
                    // 장애물을 포함하지 않으면 ㄱㄱ
                    answer[1] += l;
                }

            } else if (order[0].equals("W") && answer[1] - l >= 0) { // 서
                line = park[answer[0]];
                if (!line.substring(answer[1] - l, answer[1]).contains("X")) {
                    answer[1] -= l;
                }

            } else if (order[0].equals("S") && answer[0] + l < h) { // 남 - park[i] 인덱스 증가
                line = symmetryPark[answer[1]];
                if (!line.substring(answer[0]+1, answer[0]+l+1).contains("X")){
                    answer[0] += l;
                }

            } else if (order[0].equals("N") && answer[0] - l >= 0) { // 북 - park[i] 인덱스 감소
                line = symmetryPark[answer[1]];
                if (!line.substring(answer[0] - l, answer[0]).contains("X")){
                    answer[0] -= l;
                }

            }

        }

        // 출력
        System.out.println("위치 출력 >> "+answer[0]+", "+answer[1]);

    }



    // ver4 - 장애물 Index 정보만 모아두고 확인
}
