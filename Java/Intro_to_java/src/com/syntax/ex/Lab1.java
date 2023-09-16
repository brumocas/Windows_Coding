package com.syntax.ex;

public class Lab1 {
    public static void main(String[] args) {

        System.out.println("Hello and welcome Bruno Costa!");
        int width;
        int height;
        int area;
        double radius = 10.0;
        double pi = 3.14;
        boolean result = true;

        int[] daysMonths = new int[12];
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        width = 8;
        height = 12;
        area = width * height;

        daysMonths[0] = 31;
        daysMonths[1] = 28;

        System.out.println(monthNames[0] + " has " + daysMonths[0] + " days.");
        System.out.println("The area is " + area);
        System.out.println("The number of months are " + monthNames.length);

    }
}
