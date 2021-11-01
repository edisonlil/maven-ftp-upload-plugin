package com.github.edisonlil.properties;

/**
 * description
 *
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
    String ftpRemoteRootDir;

    /**
     * 远程目录
     */
    String ftpRemoteDir;


    /**
     * 文件目录
     */
    String targetPath;


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

    public String getFtpRemoteRootDir() {
        return ftpRemoteDir == null ? "/" : ftpRemoteDir;
    }

    public void setFtpRemoteRootDir(String ftpRemoteRootDir) {
        this.ftpRemoteRootDir = ftpRemoteRootDir;
    }

    public String getFtpRemoteDir() {
        return ftpRemoteDir;
    }

    public void setFtpRemoteDir(String ftpRemoteDir) {
        this.ftpRemoteDir = ftpRemoteDir;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public String getTargetFile() {
        return targetFile;
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
                ", ftpRemoteRootDir='" + ftpRemoteRootDir + '\'' +
                ", ftpRemoteDir='" + ftpRemoteDir + '\'' +
                ", targetPath='" + targetPath + '\'' +
                ", targetFile='" + targetFile + '\'' +
                '}';
    }
}
