package com.ld.digitallibrary.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "aws")

public class S3Properties {

    private final String accessKey;

    private final String secretKey;

    private final String serviceEndpoint;

    private final String region;

}
