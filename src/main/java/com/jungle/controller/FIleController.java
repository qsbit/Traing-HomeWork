package com.jungle.controller;

import com.jungle.entity.FileEntity;
import com.jungle.service.FileService;
import com.jungle.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class FIleController {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private FileService fileService;

    private String fileUploadPath = "E:\\springbootUpload";

    private HttpServletResponse response;

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }



    @RequestMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping("/toDownload")
    public String toDownload(Model model){
        List<FileEntity> fileEntities = fileService.findAll();
        model.addAttribute("files",fileEntities);
        model.addAttribute("hello","world");

        // 域 request session

        return "download";
    }

    @RequestMapping("/upload")
    public void upload (@RequestParam("file") MultipartFile file) throws Exception{
        Map<String, Object> map = fileUtil.upload(fileUploadPath,"img",file);
        //存数据库
//        Jedis jedis = new Jedis("192.168.101.137",6379);
//        jedis.set((String) map.get("fileName"),(String) map.get("fileSqlPath"));

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName((String) map.get("fileName"));
        fileEntity.setFileSqlPath((String) map.get("fileSqlPath"));
        fileService.insertFileInfo(fileEntity);
    }

    @RequestMapping("/download")
    public void downLoad(String fileName, String fileSqlPath, HttpServletResponse response)throws Exception{
        fileUtil.downLoad(fileName,fileUploadPath,fileSqlPath,response);
    }


    @RequestMapping("/downloadById/{id}")
    public void downloadById(@PathVariable Integer id, HttpServletResponse response) throws Exception{
        //根据id查询文件信息
        FileEntity fileEntity = fileService.findById(id);
        fileUtil.downLoad(fileEntity.getFileName(),fileUploadPath,fileEntity.getFileSqlPath(),response);
    }
}
