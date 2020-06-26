package com.example.wechatwork.gateway;

import com.example.wechatwork.model.WeChatMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "coreService", url = "${gateways.coreService.baseurl}")
public interface CoreServiceFeignClient {

    @PostMapping(value = "/message/")
    void publishWeChatMessage(final WeChatMessage weChatMessage);

}
