package com.ld.digitallibrary.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.ld.digitallibrary.exception.FileException;
import com.ld.digitallibrary.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final AmazonS3 s3client;

    @Value("${aws.bucket-name}")
    private String bucketName;

    @Override
    public String uploadFile(MultipartFile file) {
        if (!s3client.doesBucketExistV2(bucketName)) {
            s3client.createBucket(bucketName);
        }
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            s3client.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), objectMetadata);
        } catch (NullPointerException e) {
            log.warn(e.getMessage());
            throw new FileException("File must not be empty", e);
        } catch (IOException e) {
            log.warn("File cannot be converted to input stream");
            throw new FileException("File cannot be converted to input stream", e);
        }
        return file.getOriginalFilename();
    }

    @Override
    public byte[] downloadFile(String filename) {
        try {
            S3Object s3object;
            s3object = s3client.getObject(bucketName, filename);
            S3ObjectInputStream inputStream = s3object.getObjectContent();
            return IOUtils.toByteArray(inputStream);
        } catch (AmazonS3Exception e) {
            log.warn(e.getMessage());
            throw new FileException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            log.warn("Filename in database must not be Null");
            throw new FileException("Filename in database must not be Null", e);
        } catch (IOException e) {
            log.warn("S3 storage input stream cannot be converted to byte array");
            throw new FileException("S3 storage input stream cannot be converted to byte array", e);
        }
    }

    @Override
    public void deleteFile(String filename) {
        try {
            s3client.deleteObject(bucketName, filename);
            DeleteObjectsRequest delObjReq = new DeleteObjectsRequest(bucketName)
                    .withKeys(filename);
            s3client.deleteObjects(delObjReq);
        } catch (IllegalArgumentException e) {
            log.warn("Filename in database must not be Null");
            throw new FileException("Filename in database must not be Null", e);
        }
    }
}
