package com.dds.designpattern.proxy.dynamicproxy.custome;

import java.io.*;

public class FileUtil {

    public static byte[] read(String file){
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int r;
            try{
                while((r = inputStream.read())!=-1){
                    byteArrayOutputStream.write(r);
                }
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }catch (Exception e){
              e.printStackTrace();
            }finally {
                try {
                    byteArrayOutputStream.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
