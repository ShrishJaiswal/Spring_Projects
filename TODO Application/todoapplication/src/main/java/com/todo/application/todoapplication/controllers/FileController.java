package com.todo.application.todoapplication.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;


@RestController
@RequestMapping("/file")
public class FileController {

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/single")
    public String uploadSingle(@RequestParam("image") MultipartFile file){ // requestParam should be equal to form-data body key
        logger.info("Name : {}", file.getName());
        logger.info("Content Type : {}", file.getContentType());
        logger.info("Original File Name : {}", file.getOriginalFilename());
        logger.info("File Size : {}", file.getSize());
        return "Handling Single File Upload";
    }

    /*
    Multiple file uploading
     */

    @PostMapping("/multiple")
    public String uploadMultiple(@RequestParam("image") MultipartFile[] file){
        Arrays.stream(file).forEach(files->{
            logger.info("File Name : {}", files.getOriginalFilename());
            logger.info("File Type : {}", files.getContentType());
            System.out.println("----------------------------------------------");
        });
        return "Handling Multiple Files Upload";
    }

    /*
    Sending image files in response
     */
    @GetMapping("/sendimage")
    public void sendImageHandler(HttpServletResponse response){
        // image to send
        try {
            InputStream fileInput = new FileInputStream("images/dog.jpeg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInput, response.getOutputStream());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

}
