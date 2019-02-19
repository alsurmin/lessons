package com.company;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        Locale locale2 = new Locale("ru", "RU");
        Locale locale3 = new Locale("de", "GR");

        //System.out.println(Locale.getDefault());
//        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale loc : locales) {
//            System.out.println(loc);
//        }

        System.out.println(NumberFormat.getCurrencyInstance(locale).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale2).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale3).format(1000));

        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale2).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale3).format(new Date()));


    }
}
