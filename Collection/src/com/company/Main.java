package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	int[] array = new int[15];
        List collection = new ArrayList();
        Set collection2 = new LinkedHashSet();
        Queue collection3 = new PriorityQueue();
        Map map = new HashMap();

        collection2.add("1");
        collection2.add("3");
        collection2.add("2");

        //collection2.remove("2");

        for (Object o : collection2){
            System.out.println(o);
        }

    }
}
