package com.jungle.mapper;

import com.jungle.entity.FileEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    /**
     * 自增
     * @param fileEntity
     * @return
     */
    @Insert("insert into hsd_file(file_name,file_sql_path) value(#{fileName},#{fileSqlPath})")
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
