package com.ruyin.code.core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class TextFile extends ArrayList<String>{

    public static String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName).getAbsolutePath()));
            try{
                String s;
                while((s = br.readLine())!= null){
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                br.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
