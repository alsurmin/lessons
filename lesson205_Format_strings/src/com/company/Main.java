package com.company;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        String s = "On 22.02.2017 was hurricane";
        String s2 = "On 23.02.2017 was sunny";
        String s3 = "On {0, date, full} was {1} {2, choice, 0#no houses|1#one house|2#{2} houses} buildings was destroyed";

        String s4 = MessageFormat.format(s3, new GregorianCalendar(2018, 2,9).getTime(), "hurricane", 10);

        System.out.println(s4);
    }
}
