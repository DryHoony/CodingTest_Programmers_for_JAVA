package programmers.level1;

public class SmallSizeSubString { // 크기가 작은 부분 문자열

//    public static void main(String[] args) { // 런타임 에러
//        String t = "10203";
//        String p = "15";
//        int count = 0;
//
//        for (int i = 0; i < t.length()-p.length()+1; i++) {
//            // t.charAt(i)가 일치하면 쭉 비교
//            if (t.charAt(i) <= p.charAt(0)) {
//                if (Integer.parseInt(t.substring(i, i + p.length())) <= Integer.parseInt(p)) {
//                    count++;
//                }
//            }
//        }
//
//        System.out.println(count);
//
//
//    }

    public static void main(String[] args) {
        // t의 부분문자열이 p보다 작거나 같은지 확인
        String t = "10203";
        String p = "15";
        int count = 0;
        boolean flag;

        for (int i = 0; i < t.length()-p.length()+1; i++){
            if (t.charAt(i) < p.charAt(0)) count++; // 숫자 아닌데 비교연산 괜찮나?
            else if (t.charAt(i) == p.charAt(0)) { // 밑으로 쭉 비교

                flag = true; // 초기화
                for (int j = 0; j < p.length(); j++) {
                    if(t.charAt(i+j) < p.charAt(j)){
                        break; // flag는 true유지
                    }
                    else if (t.charAt(i+j) == p.charAt(j)) { // 같은 숫자로 끝나는 경우 flag 연산 필요
                        continue; // flag는 true유지
                    } else if (t.charAt(i+j) > p.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;

            }


        }

        System.out.println(count);

    }
}
