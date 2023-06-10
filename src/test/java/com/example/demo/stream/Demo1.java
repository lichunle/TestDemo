package com.example.demo.stream;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class Demo1 {


    public static void main(String[] args) {
        File source = new File("F:\\BaiduNetdiskDownload\\sourcefile1.txt");
        File dest = new File("F:\\BaiduNetdiskDownload\\sourcefile5.txt");
        try {
//            copyFileUsingFileStream(source, dest);
//            copyFileUsingFileChannel(source, dest);
//            copyFileUsingCommonUtil(source, dest);
            copyFileUsingFiles(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法一：使用FileInputStream
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileUsingFileStream(File source, File dest) throws IOException {
        InputStream input = null;
        OutputStream out = null;
        try {
            input = new FileInputStream(source);
            out = new FileOutputStream(dest);

            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0) {
                out.write(buf, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            input.close();
            out.close();
        }
    }

    /**
     * 方法二： 使用FileChannel
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileUsingFileChannel(File source, File dest) throws IOException {

        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            inputChannel.close();
            outputChannel.close();
        }


    }

    /**
     * 方法三： 使用Commons IO
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileUsingCommonUtil(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }

    /**
     * 方法四： 使用Files
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileUsingFiles(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
}
