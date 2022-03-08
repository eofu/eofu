package com.example.eofu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test13 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Download\\qqFile\\fiddler1.mp4");
        
        FileInputStream fileInputStream = new FileInputStream(file);
        int size = fileInputStream.available() / (1024 << 10);
        System.out.println(size);
        byte[] bytes = new byte[1024 * 50];
        if (size > 50) {
            File file1 = new File("D:\\Download\\cut" + file.getName());
            file1.mkdirs();
            for (int i = 0; i < size / 50; i++) {
                fileInputStream.read(bytes);
            }
            // fileInputStream.read(bytes);
            // fileInputStream.
        }
        
    }
}
