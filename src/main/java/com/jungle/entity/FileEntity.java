package com.jungle.entity;

public class FileEntity {
    private Integer id;
    private String fileName;
    private String fileSqlPath;

    public FileEntity() {
    }

    public FileEntity(Integer id, String fileName, String fileSqlPath) {
        this.id = id;
        this.fileName = fileName;
        this.fileSqlPath = fileSqlPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSqlPath() {
        return fileSqlPath;
    }

    public void setFileSqlPath(String fileSqlPath) {
        this.fileSqlPath = fileSqlPath;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileSqlPath='" + fileSqlPath + '\'' +
                '}';
    }
}
