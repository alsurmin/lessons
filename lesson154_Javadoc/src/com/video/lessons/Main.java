package com.video.lessons;

/**
 * @author Alex
 * @version 1.1
 * @since 1.0
 * This is my Main class here, I will write my <strong>code</strong>
 * <img src="doc-files/logo.png" alt"="pics"/>
 */


public class Main {
     /**
      * This is int field where i will store my values
      */
    int myField;

     /**
      * Here start point of the program
      * @param args command line values
      */
    public static void main(String[] args) {

    }
     /**
      * This field will return i
      * @param s some other String values
      * @param i some int value
      * @throws RuntimeException when something goes wrong
      * @return i from params
      */
    int getMyField(int i, String s) {
        return  i;
    }

    /**
     * @deprecated please use {@link Main#newMethod()}
     */
    void oldMethod () {

    }

    /**
     * this some description with some link {@link OtherClass#OtherMethod()}
     * @see OtherClass#OtherMethod()
     * @see "chapter 2"
     */
    void newMethod() {

    }

}
