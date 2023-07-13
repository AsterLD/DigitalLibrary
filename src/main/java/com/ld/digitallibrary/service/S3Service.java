package com.ld.digitallibrary.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

    String uploadFile(MultipartFile file);

    byte[] downloadFile(String filename);

    void deleteFile(String filename);
}
