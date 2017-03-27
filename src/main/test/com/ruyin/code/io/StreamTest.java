package com.ruyin.code.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by ruyin on 2017/3/23.
 */
public class StreamTest {

    @Test
    public void streamTest1() throws IOException {
        FileWriter writer = new FileWriter(new File("d:" + File.separator + "bcd.txt"),true);
        OutputStream os = new FileOutputStream(new File("d:" + File.separator + "abc.txt"));

        String str ="gg fly";
        String charStr = "Hello World!";

        byte[] bytes = str.getBytes();
        //字节流直接操作文件本身
        os.write(bytes);
        writer.write(charStr);
        //字节流无缓冲,可不关闭流就可完成对文件的操作
        //os.close();
        //字符流采用缓冲区(内存区域),强制将缓存区的内容刷到磁盘使用flush方法
        //writer.flush();
        //字符流关闭的时候会将缓冲区的内容flush到磁盘再关闭,建议手动flush
        writer.close();
    }

    @Test
    public void byteStreamTest2() throws IOException {
        //FileReader reader = new FileReader(new File("d:" + File.separator + "abc.txt"));
        FileInputStream fis = new FileInputStream(new File("d:" + File.separator + "abc.txt"));
        byte[] buffer = new byte[2048];
        fis.read(buffer);
        //fis.read(buffer,8,1);
        //获取具体某一位上的字符
        System.out.println(new String(buffer,5,1));
        fis.close();
        //reader.read();
    }
}
