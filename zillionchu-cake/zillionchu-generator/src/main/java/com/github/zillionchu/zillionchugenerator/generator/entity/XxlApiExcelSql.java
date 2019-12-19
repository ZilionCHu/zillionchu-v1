package com.github.zillionchu.zillionchugenerator.generator.entity;

public class XxlApiExcelSql {
    private int id ;
    private String uploadFileName;
    private String uploadFilePath;
    private byte [] uploadFileContant;
    private String downFileName;
    private String downFilePath;
    private byte [] downFileContant;

    public byte[] getUploadFileContant() {
        return uploadFileContant;
    }

    public void setUploadFileContant(byte[] uploadFileContant) {
        this.uploadFileContant = uploadFileContant;
    }

    public byte[] getDownFileContant() {
        return downFileContant;
    }

    public void setDownFileContant(byte[] downFileContant) {
        this.downFileContant = downFileContant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }



    public String getDownFileName() {
        return downFileName;
    }

    public void setDownFileName(String downFileName) {
        this.downFileName = downFileName;
    }

    public String getDownFilePath() {
        return downFilePath;
    }

    public void setDownFilePath(String downFilePath) {
        this.downFilePath = downFilePath;
    }

}
