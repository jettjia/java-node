package com.pinyougou.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Result;
import util.FastDFSClient;

/**
 * 文件上传
 * 
 * @author ThinkPad
 *
 */
@RestController
public class UploadController {
    
    @Value("${FILE_SERVER_URL}")
    private String file_server_url; // 文件服务器地址
    
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        // 1.取文件名扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        try {
            // 2.创建一个FastDFS的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            // 3.执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            // 4.拼接返回的url和ip地址，拼装完整的url
            String url = file_server_url + path; // 图片完整地址
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
