package com.github.edisonlil.util;

import java.io.File;

/**
 * description
 *
 * @author edison
 * @since 2021/11/02 09:53
 */
public class FileUtil {

    public static File newFile(String path,String file){
        return new File(path,file);
    }


    public static File newFile(String path,boolean readable,boolean writable){
        File file = new File(path);
        file.setReadable(readable);//设置可读权限
        file.setWritable(writable);//设置可写权限
        return file;
    }


    public static String getFullName(File file){
        return file.toString();
    }

}
