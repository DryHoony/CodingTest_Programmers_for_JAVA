package defaultPackage;

public class BracketChange {

    public static void main(String[] args) {
        String str;
        str = "[[1, 0, 1, 0, 1, 1], [1, 0, 1, 0, 0, 0], [1, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0], [1, 0, 0, 1, 0, 1], [1, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1]]";


        System.out.println(change(str));
    }

    public static String change(String s){
        s = s.replace("[", "{");
        s = s.replace("]", "}");


//        s = s.replaceAll("\\[" ,"{"); // 정규표현식을 인수로 받음
//        s = s.replaceAll("\\]", "}");

        return s;
    }
}
