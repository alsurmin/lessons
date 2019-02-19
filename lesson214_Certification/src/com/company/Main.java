package com.company;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        String s = "Hello world";

        Cipher cipher = Cipher.getInstance("AES");

//        KeyGenerator kgen = KeyGenerator.getInstance("AES");
//        kgen.init(128);
//        SecretKey key = kgen.generateKey();

        SecretKeySpec key = new SecretKeySpec("Bar12345BAr12345".getBytes(), "AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(s.getBytes());

        for (byte b : bytes) {
            System.out.print(b);
        }

        System.out.println("\n");

        Cipher decriptCipher = Cipher.getInstance("AES");
        decriptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decriptedBytes = decriptCipher.doFinal(bytes);

        for (byte d : decriptedBytes) {
            System.out.print((char)d);
        }

    }
}
