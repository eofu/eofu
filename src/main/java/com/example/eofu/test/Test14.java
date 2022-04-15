package com.example.eofu.test;

import java.util.Random;

public class Test14 {
    public static void main(String[] args) {
        // 97~122 a~z
        // 48~57 0~9

        Test14 test14 = new Test14();
//        String string = "3159zzz";
//        char[] chars = string.toCharArray();
//        char[] chars1 = test14.idIncrement(chars, chars.length - 1);
//        System.out.println(String.valueOf(chars1));
        for (int i = 0; i < 100; i++) {
            char a = (char) (new Random().nextInt(93) + 33);
            System.out.println(a);

        }
    }

    public int generateRandom(int range) {
        int nextInt = new Random().nextInt(range);
        if (nextInt > 57 && nextInt < 97) {
            nextInt = generateRandom(range);
        }
        return nextInt;
    }


    public char[] idIncrement(char[] chars, int index) {
        if (chars[index] == 122) {
            idIncrement(chars, index - 1);
        }

        chars[index] = chars[index] == 122 ? chars[index] :
                chars[index] == 57 ? chars[index] = 97 :
                        (char) (chars[index] + 1);
        return chars;
    }
}
