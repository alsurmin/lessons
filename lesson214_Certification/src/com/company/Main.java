package com.company;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        String s = "Hello world";

        Cipher cipher = Cipher.getInstance("AES");



    }
}
