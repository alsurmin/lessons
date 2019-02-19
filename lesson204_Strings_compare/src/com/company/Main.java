package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bb");
        list.add("cc");
        list.add("aa");
        list.add("AA");
        list.add("ba");
        list.add("ää");

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
//        collator.setStrength(Collator.SECONDARY);
//        collator.setStrength(Collator.TERTIARY);
        Collections.sort(list, collator);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
//