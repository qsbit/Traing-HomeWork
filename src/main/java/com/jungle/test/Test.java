package com.jungle.test;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File inFile = new File("C:\\Users\\WWJ\\Desktop\\a.txt");
        File outFile = new File("C:\\Users\\WWJ\\Desktop\\b.txt");

        InputStream in = null;
        OutputStream out = null;

        try {
             in = new FileInputStream(inFile);
             out = new FileOutputStream(outFile);

            // 判断输出文件是否存在 不存在创建
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            // 在内存中开辟的缓冲区 读
            // 每次读取十个字节
            byte[] buf = new byte[10];
            int len = -1;
            while ((len=in.read(buf))!=-1){
                out.write(buf,0,len);
            }
            System.out.println("文件复制成功！");
        } catch (Exception e) {
            System.out.println("文件复制失败！");
            e.printStackTrace();
        }finally {
            // 关闭输入输出流
            try {
                if(in != null) in.close();
                if(out != null) out.close();
            }catch (Exception e){

            }
        }
    }
}
