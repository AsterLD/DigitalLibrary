package com.ld.digitallibrary.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.ld.digitallibrary.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service {
    private final AmazonS3 s3client;

    @Value("${aws.bucket-name}")
    private String bucketName;

    @Override
    public String uploadFile(InputStream is, String filename) {
        if (!s3client.doesBucketExistV2(bucketName)) {
            s3client.createBucket(bucketName);
        }
        ObjectMetadata objectMetadata = new ObjectMetadata();
        s3client.putObject(bucketName, filename, is, objectMetadata);
        return filename;
    }

    @Override
    public byte[] downloadFile(String filename) {
        S3Object s3object;
        s3object = s3client.getObject(bucketName, filename);
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String deleteFile(String filename) {
        s3client.deleteObject(bucketName, filename);
        DeleteObjectsRequest delObjReq = new DeleteObjectsRequest(bucketName)
                .withKeys(filename);
        s3client.deleteObjects(delObjReq);
        return "deleted: " + filename;
    }
}
