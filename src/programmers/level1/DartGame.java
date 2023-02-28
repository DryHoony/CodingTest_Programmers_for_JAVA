package programmers.level1;

public class DartGame { //다트게임 카카오기출 https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=java


    public static void main(String[] args) {
        String dartResult = "1T2D3D#";
//        int answer = 0;
        int a,b,c;
        String p; //SDT
        String o; //옵션
        int i = 0;

        if(dartResult.substring(0,2).equals("10")){
            a = 10;
            i+=2;
        }else{
            a = Integer.parseInt(dartResult.substring(0,1));
            i++;
        }

        p = dartResult.substring(i,i+1);
        if(p.equals("D")) a = a*a;
        else if(p.equals("T")) a = a*a*a;
        i++;

        //옵션
        o = dartResult.substring(i,i+1);
        if(o.equals("*")){
            a *= 2;
            i++;
        } else if (o.equals("#")) {
            a *= -1;
            i++;
        }
        // a연산 끝 b차례

        if(dartResult.substring(i,i+2).equals("10")){
            b = 10;
            i+=2;
        }else{
            b = Integer.parseInt(dartResult.substring(i,i+1));
            i++;
        }

        p = dartResult.substring(i,i+1);
        if(p.equals("D")) b = b*b;
        else if(p.equals("T")) b = b*b*b;
        i++;

        //옵션
        o = dartResult.substring(i,i+1);
        if(o.equals("*")){
            a *= 2;
            b *= 2;
            i++;
        } else if (o.equals("#")) {
            b *= -1;
            i++;
        }
        // b연산 끝 c차례

        if(dartResult.substring(i,i+2).equals("10")){
            c = 10;
            i+=2;
        }else{
            c = Integer.parseInt(dartResult.substring(i,i+1));
            i++;
        }

        p = dartResult.substring(i,i+1);
        if(p.equals("D")) c = c*c;
        else if(p.equals("T")) c = c*c*c;
        i++;

        //옵션
//        o = dartResult.substring(i,i+1);
        o = dartResult.substring(dartResult.length()-1);
        if(o.equals("*")){
            b *= 2;
            c *= 2;
            i++;
        } else if (o.equals("#")) {
            c *= -1;
            i++;
        }

        System.out.println(a+b+c);


    }
}
