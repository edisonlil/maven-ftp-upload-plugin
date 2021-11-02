package com.github.edisonlil.util;

import org.apache.maven.plugin.logging.Log;
import cn.hutool.extra.ftp.Ftp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * FTP上传
 *
 * @author edison
 * @since 2021/11/01 17:03
 */
public class FtpClient implements Closeable {

    private Ftp ftp;

    Log log;


    public FtpClient(String host,Integer port,String username,String password,String pwd,Log log){
        this.ftp = new Ftp(host,port,username,password);
        mkdir(pwd);
        ftp.cd(pwd);
        this.log = log;
    }

    public boolean hasDir(String path){
        return ftp.exist(path);
    }


    public void delDir(String path){
        ftp.delDir(path);
    }

    /**
     * 文件上传
     * @param remoteDir
     * @param prefixPath
     * @param filePath
     * @return
     */
    public void upload(String remoteDir,String prefixPath,String filePath){

        File root =  FileUtil.newFile(filePath,true,true);
        if(!root.isDirectory()){
            uploadFile(remoteDir,prefixPath,filePath);
            return;
        }
        Arrays.stream(root.listFiles()).forEach(file ->{
            if(file.isDirectory()){
                String descPath = pathReplace(file,prefixPath,remoteDir);
                log.info("上传的目录："+descPath);
                upload(remoteDir,prefixPath,file.getPath());
            }else {
                uploadFile(remoteDir,prefixPath,file.getPath());
            }
        });
    }


    /**
     * 创建远程目录
     * @param path
     */
    public void mkdir(String path){
        if(!ftp.isDir(path)){
            ftp.mkdir(path);
        }
    }

    /**
     * 文件上传
     * @param remoteDir
     * @param prefixPath
     * @param filePath
     * @throws RuntimeException
     */
    public void uploadFile(String remoteDir,String prefixPath,String filePath) throws RuntimeException{

        File file =  FileUtil.newFile(filePath,true,true);
        if(file.isDirectory()){
            throw new RuntimeException(FileUtil.getFullName(file)+"是一个目录");
        }
        String descPath = pathReplace(file,prefixPath,remoteDir);
        log.info("上传的目录："+descPath+" 上传的文件名："+file.getName());
        mkdir(descPath);
        ftp.upload(descPath, file);

    }

    /**
     * 路径名替换成根目录路径
     * @param file 文件
     * @param prefixPath 本地文件目录前缀
     * @param remoteDir  上传到指定的远程目录
     * @return
     */
    String pathReplace(File file,String prefixPath,String remoteDir){

        String descPath = file.getPath().replace(prefixPath,remoteDir);
        descPath = descPath.replace("\\","/");
        descPath = descPath.replace(file.getName(),"");

        return descPath;
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
