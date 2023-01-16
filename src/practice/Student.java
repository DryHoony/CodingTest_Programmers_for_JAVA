package practice;

import java.util.Objects;

public class Student { // Object와 오버라이딩(equals, hashCode 메소드)

    String name;
    String number;
    int birthYear;

    // equals, toString, hashCode 메소드 오버라이딩
    // 상단의 코드-생성으로 간편하게 가능하다

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthYear == student.birthYear && name.equals(student.name) && number.equals(student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, birthYear);
    }

    public static void main(String[] args){
        Student s1 = new Student();
        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1995;

        Student s2 = new Student();
        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1995;

        if(s1.equals(s2)){
            System.out.println("같다");
        }else{
            System.out.println("다르다");
        }

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }


}
