package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        Set<String> password = new HashSet<>();
        byte[] pass = new byte[8];
        int i = 0;
        boolean isDigit = false;
        boolean isUpCase = false;
        boolean isLowCase = false;
        boolean isContain;
        while (i < pass.length) {
            int ch = (int) (Math.random() * 75 + 48);
            if (ch > 47 && ch < 58) {    // || ch > 64 && ch < 91 || ch > 96 && ch < 123) {
                pass[i] = (byte) ch;
                i++;
                isDigit = true;
            } else {
                if (ch > 64 && ch < 91) {
                    pass[i] = (byte) ch;
                    i++;
                    isUpCase = true;
                } else {
                    if (ch > 96 && ch < 123) {
                        pass[i] = (byte) ch;
                        i++;
                        isLowCase = true;
                    }
                }
            }
        }
        String pas = new String(pass);
        isContain = password.add(pas);

        if (isDigit & isUpCase & isLowCase & isContain) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                outputStream.write(pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return outputStream;
        }
        return getPassword();
    }
}