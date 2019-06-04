package com.example.springbootjwtservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @创建人
 * @创建时间 2019/4/29
 * @描述
 */
@Data
public class TokenProperties {
    /**
     * token的过期时间
     */
    @Value("${battcn.security.token.expirationTime}")
    private Integer expirationTime;
    /**
     * 发行人
     */
    @Value("${battcn.security.token.issuer}")
    private String issuer;
    /**
     * 使用的签名KEY
     */
    @Value("${battcn.security.token.signingKey}")
    private String signingKey;
    /**
     * 刷新过期时间
     */
    @Value("${battcn.security.token.refreshExpTime}")
    private Integer refreshExpTime;
}
