package com.example.wechatwork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@EnableCaching
@EnableFeignClients(basePackages = "com.example.wechatwork.gateway")
@ConfigurationProperties("wechatwork")
public class WechatWorkConfig {

    @Value("${wechatwork.corpid:test_corp_identifier}")
    private String corpid;

    @Value("${wechatwork.corpsecret:test_corp_secret_string}")
    private String corpsecret;

    @Value("${wechatwork.externalcontact.token:test_ext_contact_token}")
    private String externalContactToken;

    @Value("${wechatwork.externalcontact.aesKey:test_aesKey}")
    private String externalContactAesKey;

    public String getCorpid() {
        return corpid;
    }

    public String getCorpsecret() {
        return corpsecret;
    }

    public String getExternalContactToken() {
        return externalContactToken;
    }

    public String getExternalContactAesKey() {
        return externalContactAesKey;
    }
}