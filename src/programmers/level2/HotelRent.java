package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HotelRent { // 호텔대실


    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        // 1~1000개 [시작시간, 종료시간]
        // 사용한 객실은 10분간 청소 후 사용가능
        // 필요한 최소 객실 수 return

        // book_time 정렬 - 시작시간 빠른순, 종료시간 빠른순 (오름차순)
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].split(":")[0].equals(o2[0].split(":")[0])){ // 시작 '시' 같으면
                    if(o1[0].split(":")[1].equals(o2[0].split(":")[1])){ // 시작 '분'까지 같으면
                        if(o1[1].split(":")[0].equals(o2[1].split(":")[0])){ // 종료 '시' 같으면
                            return Integer.parseInt(o1[1].split(":")[1]) - Integer.parseInt(o2[1].split(":")[1]);
                        }
                        return Integer.parseInt(o1[1].split(":")[0]) - Integer.parseInt(o2[1].split(":")[0]);
                    }
                    return Integer.parseInt(o1[0].split(":")[1]) - Integer.parseInt(o2[0].split(":")[1]);
                }
                return Integer.parseInt(o1[0].split(":")[0]) - Integer.parseInt(o2[0].split(":")[0]);
            }
        });



        // 방의 갯수를 동적으로 생성 - 끝나는 시간을 가지는 Array
        ArrayList<Integer> room = new ArrayList<>();
        // 끝나는 시간+10분 = '사용가능 시간' 할당!

        for(String[] book:book_time){
            int start = timeCalculateMinute(book[0]);
            int end = timeCalculateMinute(book[1])+10;
            boolean emptyFlag = true;
            System.out.println();
            System.out.println("탐색 >> " + start+"-"+end);

            // 빈방 있으면 할당(끝나는 시간)
            for (int i = 0; i < room.size(); i++) {
                if(room.get(i) <= start){ // 사용 가능하면
                    room.remove(i);
                    room.add(end);
                    Collections.sort(room); // 정렬 시간 크게 안걸릴 것으로 예상
                    emptyFlag = false;
                    System.out.println("빈 방 할당 >> " + room);
                    break;
                }
            }

            // 빈방 없으면 새 방 생성
            if(emptyFlag){
                room.add(end);
                Collections.sort(room);
                System.out.println("새 방 생성! >> " + room);
            }

        }



        System.out.println("답은 = " + room.size());
    }

    public static int timeCalculateMinute(String str){
        int time=0;

        time += Integer.parseInt(str.split(":")[0])*60;
        time += Integer.parseInt(str.split(":")[1]);

        return time;
    }
}
