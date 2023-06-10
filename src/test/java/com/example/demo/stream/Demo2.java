package com.example.demo.stream;

import java.io.*;

public class Demo2 {


    public static void main(String[] args) {
//        String str = "Hello, bro!";
        String str = "你好，我来自中国!";
//        outputData(str);
        readFileForByte();
//        readFileForReader();
        System.out.println("=======================");
    }

    public static void outputData(String str) {


        try {
            OutputStream output = new FileOutputStream("F:\\BaiduNetdiskDownload\\05161421.txt");
            byte[] bytes = str.getBytes();
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileForByte() {

        try {
            InputStream input = new FileInputStream("F:\\BaiduNetdiskDownload\\05161421.txt");

            int content;
            while((content   = input.read())!= -1) {
                System.out.print((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileForReader() {

        try {
            Reader reader = new FileReader("F:\\BaiduNetdiskDownload\\05161421.txt");
            int content;
            while((content = reader.read()) != -1) {
                System.out.print((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
