package skillpractice;

public class ControlFlowStatement {



    public static void main(String[] args) {

        //@ if 조건문

        int i = 0;
        if (i==1 && i>0){
            System.out.println("조건식에서 논리연산자를 잘 활용하자");
            System.out.println("실행문1");
            System.out.println("실행문2");
        } else if (i==2 || i<0) {
            System.out.println("else-if 문의 수는 제한없음");
        } else{
            System.out.println("마지막 else    문은 하나 또는 생략");
        }

        //한줄 실행문
        boolean flag = false;
        if(flag) System.out.println("{}괄호없이는 실행문 한줄만 가능");
        else System.out.println("else 문도 물론 가능하다");

        //삼항 연산자
        // 변수 = (조건문) ? 참반환값 : 거짓반환값
        int n = (4>5) ? 1 : 0;

        // 일반적으로 삼항 연산자는 '반환값'을 통해 변수할당만 가능하지만, 이런식으로 응용도 가능하다.
        System.out.println( (true) ? "참" : "거짓" ); // 어떤값을 출력(반환)할지 삼항 연산자로 결정

        // switch문 - int값(정확히는 integer promotion값)만 조건 값으로 사용가능하지만, ifelse보다 효율적
        int switchVariable = 0;
        switch (switchVariable){
            case 1:
                System.out.println("switchVariable == 1 일때 실행문");
                break; // switch문을 빠져나간다. 없으면 다른 case도 실행
            case 2:
            case 3: // ||연산자 처럼 사용하려면 case를 여러개 나열하면 된다.
            case 4:
                System.out.println("2,3,4 에 해당");

            default:
                System.out.println("case 절에 해당하는게 없을 때 실행, 생략가능");
                break;
        }


        //@ while 문
        i=0;
        while(i<10){
            System.out.println();
            i++;
        }

        while(true){
            System.out.println();
            if(true){
                break;
            }
        }

        // do-while문 - 무조건 한번은 실행
        i=0;
        do{
            if (i==3) continue; // 다음 조건식으로 넘어간다
            System.out.println(i);
            i++;
            if (i==5) break;
        }while(i>0);


        //@ for문 (초기식; 조건식; 증감식){}
        for(i=0; i<10; i++){
            if (i%2==0) continue; // 다음 조건식으로 넘어간다.
            if (i==9) break; // 반복문을 빠져나온다.
            System.out.println(i);
        }

        //Enhanced for문, for each구문 - 주로 배열과 함께 사용
        int[] array = {1,2,4,5};
        for(int a:array){
            System.out.println(a);
        }

    }

}
