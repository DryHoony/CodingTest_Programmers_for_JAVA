package skillpractice;

public class String {
    // 스트링 String



    public static void main(java.lang.String[] args) {
        java.lang.String str = "String"; // ""로 생성해야 한다
//        String str0 = 'wrong';  // ''로 생성하면 오류

        // 숫자를

        // 추가하기
        java.lang.String strPlus = str;
        strPlus += "plus";
//        System.out.println(strPlus);

        //스트링 뒤집기 - StringBuilder 이용
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        java.lang.String reverseStr = sb.toString();

        // 한글자씩 배열로 반환 - split("")
        java.lang.String[] strList = str.split("");
//        for(String s:strList){
//            System.out.println(s);
//        }


        // 인덱스 자르기 - charAt
//        for(int i=0; i<str.length(); i++){
//            System.out.println(str.charAt(i));
//        }




        // 반복출력 - String.repeat
//        System.out.println(str.repeat(3));
//        for(int i=1; i<4; i++){
//            System.out.println(str.repeat(i));
//        }


        // 대체하기, 바꾸기 - replace
        java.lang.String newStr = str.replace("S", "NewS");
//        String newStr = str.replace("S", ""); // 특정문자 제거도 가능
//        System.out.println(newStr);


    }








}
