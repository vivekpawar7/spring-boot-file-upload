package com.spring.fileupload.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public void init();
    public void save(MultipartFile file);
}
