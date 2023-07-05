package com.ld.digitallibrary.service;

import java.io.InputStream;

public interface S3Service {

    String uploadFile(InputStream is, String filename);

    byte[] downloadFile(String filename);

    String deleteFile(String filename);
}
