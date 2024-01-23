package com.ld.digitallibrary.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(S3Properties.class)
public class S3Config {

    private final S3Properties s3Properties;

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                s3Properties.getAccessKey(),
                s3Properties.getSecretKey());
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        s3Properties.getServiceEndpoint(),
                        s3Properties.getRegion()))
                .build();
    }
}
