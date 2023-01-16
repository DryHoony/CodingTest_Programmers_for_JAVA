package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class TimeExam {
    public static void main(String[] args) {

        LocalDateTime timePoint = LocalDateTime.now(); // 현재 날짜와 시간

//        LocalDate theDate = timePoint.toLocalDate();
        Month month = timePoint.getMonth();
        int hour = timePoint.getHour();
        int minute = timePoint.getMinute();
        int second = timePoint.getSecond();

        System.out.println(month);
        System.out.println(hour+":"+minute+":"+second);

    }
}
