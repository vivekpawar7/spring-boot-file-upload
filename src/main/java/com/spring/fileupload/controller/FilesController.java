package com.spring.fileupload.controller;

import com.spring.fileupload.message.ResponseMessage;
import com.spring.fileupload.service.FileStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

    @Autowired
    FileStorageServiceImpl fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) {
        String message = "";
        try{
            fileStorageService.save(file);
            message="File uploaded successfully " + file.getOriginalFilename();
            return ResponseEntity.  status(HttpStatus.CREATED).body(new ResponseMessage(message));
        } catch (Exception e) {
            message="Could not upload file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}
