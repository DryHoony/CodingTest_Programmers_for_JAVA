package programmers.level0;



public class StringReplace {

    public String aeiouRemove(String str){
//        str = str.replace("a","");
//        str = str.replace("e","");
//        str = str.replace("i","");
//        str = str.replace("o","");
//        str = str.replace("u","");
//
//        return str;

//        return str.replaceAll("[aeiou]","");
        return str.replaceAll("a|e|i|o|u","");

    }

    public static void main(String[] args) {
        StringReplace sr = new StringReplace();
        System.out.println(sr.aeiouRemove("nice to meet you"));

    }
}
