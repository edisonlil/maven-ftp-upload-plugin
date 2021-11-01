package com.github.edisonlil.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;

import java.io.Closeable;
import java.io.IOException;

/**
 * description
 *
 * @author edison
 * @since 2021/11/01 17:03
 */
public class FtpClient implements Closeable {

    private Ftp ftp;

    private static FtpClient client;

    private FtpClient(){ }


    public static FtpClient getClient(String host,Integer port,String username,String password,String directory) {

        if (client == null){
            synchronized (FtpClient.class){
                if(client == null){
                    client = new FtpClient();
                    client.ftp = new Ftp(host,port,username,password);
                    client.ftp.cd(directory);
                }
            }
        }
        return client;
    }

    public boolean upload(String destPath,String file){
        //上传本地文件
       return ftp.upload(destPath, FileUtil.file(file));
    }

    @Override
    public void close(){
        //关闭连接
        try {
            if(ftp != null)
                ftp.close();
        } catch (IOException e) {
           if(ftp != null){
               try {
                   ftp.close();
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
        }
    }
}
