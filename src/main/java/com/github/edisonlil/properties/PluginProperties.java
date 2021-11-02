package com.github.edisonlil.properties;

/**
 * 插件配置 读取<plugin>标签的<configuration>标签
 * <configuration>
 *  ...
 * </configuration>
 * @author edison
 * @since 2021/11/01 15:19
 */
public class PluginProperties {


    /**
     * ftp地址
     */
    String ftpHost;

    /**
     * ftp端口
     */
    Integer ftpPort = 21;

    /**
     * ftp用户名
     */
    String ftpUsername;

    /**
     * ftp密码
     */
    String ftpPassword;

    /**
     * 远程初始目录
     */
    String ftpRemoteDir;


    /**
     * 本地文件初始目录
     */
    String rootPath;


    /**
     * 要上传的目标文件
     */
    String targetFile;


    public String getFtpHost() {
        return ftpHost;
    }

    public void setFtpHost(String ftpHost) {
        this.ftpHost = ftpHost;
    }

    public Integer getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(Integer ftpPort) {
        this.ftpPort = ftpPort;
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public void setFtpUsername(String ftpUsername) {
        this.ftpUsername = ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }



    public String getFtpRemoteDir() {
      return ftpRemoteDir == null ? "/" : ftpRemoteDir;
    }

    public void setFtpRemoteDir(String ftpRemoteDir) {
        this.ftpRemoteDir = ftpRemoteDir;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getTargetFile() {
        return targetFile == null ? "":targetFile;
    }

    public void setTargetFile(String targetFile) {
        this.targetFile = targetFile;
    }

    @Override
    public String toString() {
        return "PluginProperties{" +
                "ftpHost='" + ftpHost + '\'' +
                ", ftpPort=" + ftpPort +
                ", ftpUsername='" + ftpUsername + '\'' +
                ", ftpPassword='" + ftpPassword + '\'' +
                ", ftpRemoteDir='" + ftpRemoteDir + '\'' +
                ", rootPath='" + rootPath + '\'' +
                ", targetFile='" + targetFile + '\'' +
                '}';
    }
}
