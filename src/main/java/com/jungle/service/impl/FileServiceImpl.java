package com.jungle.service.impl;

import com.jungle.entity.FileEntity;
import com.jungle.service.FileService;
import com.jungle.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public int insertFileInfo(FileEntity fileEntity) {
        return fileMapper.insertFileInfo(fileEntity);
    }

    @Override
    public List<FileEntity> findAll() {
        return fileMapper.findAll();
    }

    @Override
    public FileEntity findById(Integer id) {
        return fileMapper.findById(id);
    }
}
