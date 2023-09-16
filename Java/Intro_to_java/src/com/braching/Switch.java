package com.braching;

import com.braching.WeekdaySwitchCase;

public class Switch {
    public static void main(String[] args) {
        int y = (10 < 0) ? 2 : 5;
        System.out.println(y);

        // Create an instance of the WeekdaySwitchCase class
        WeekdaySwitchCase Weekday = new WeekdaySwitchCase();

        // Call a method to get the day of the week
        String day = Weekday.getDayOfWeek("Monday");
        System.out.println(day);
    }
}
