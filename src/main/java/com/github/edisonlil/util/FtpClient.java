package com.github.edisonlil.util;

import org.apache.maven.plugin.logging.Log;
import cn.hutool.extra.ftp.Ftp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 * description
 *
 * @author edison
 * @since 2021/11/01 17:03
 */
public class FtpClient implements Closeable {

    private Ftp ftp;

    Log log;


    public FtpClient(String host,Integer port,String username,String password,String directory,Log log){
        this.ftp = new Ftp(host,port,username,password);
        this.ftp.cd(directory);
        this.log = log;
    }



    public boolean upload(String filePath){

        File root = new File(filePath);
        root.setReadable(true);//设置可读权限
        root.setWritable(true);//设置可写权限
        if(root.isDirectory()){
            File[] childFile = root.listFiles();
            for (File file : childFile) {

                if(file.isDirectory()){
                    upload(file.getPath());
                }
                log.debug("upload path"+root.getPath()+"upload file name"+file.getName());
                ftp.upload(root.getPath(), file);

            }
        }else {
           log.debug("upload path"+root.getPath()+"upload file name"+root.getName());
           return ftp.upload(root.getPath(), root);
        }

        return true;
    }

    @Override
    public void close(){
        //关闭连接
        try {
            if(ftp != null) {
                ftp.close();
                ftp = null;
            }
        } catch (IOException e) {
           log.error(e);
        }
    }
}
