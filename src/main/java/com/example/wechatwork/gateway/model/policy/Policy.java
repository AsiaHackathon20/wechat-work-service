package com.example.wechatwork.gateway.model.policy;

import lombok.Data;

import java.util.List;

@Data
public class Policy {

    private String sid;
    private List<String> productScope;
    private List<SocialMediaPlatforms> socialMediaPlatforms;
    private String jpmEnterpriseAccount;
    private List<Contacts> contacts;
}
