package com.jungle.service;

import com.jungle.entity.FileEntity;

import java.util.List;

public interface FileService {

    /**
     * 自增
     * @param fileEntity
     * @return
     */
    int insertFileInfo(FileEntity fileEntity);

    /**
     * 查询所有
     * @return
     */
    List<FileEntity> findAll();

    /**
     * 根据id查询
     * @return
     */
    FileEntity findById(Integer id);
}
