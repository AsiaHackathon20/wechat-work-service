package com.example.wechatwork.service;

import com.example.wechatwork.gateway.PolicyGateway;
import com.example.wechatwork.gateway.model.policy.Policy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PolicyService {

    @Autowired
    private PolicyGateway policyGateway;

    private Map<String, Policy> policyMap = new HashMap<>();

    @EventListener(classes = ApplicationReadyEvent.class)
    void init() {
        log.info("Loading cache from policy server");
        List<Policy> policies = policyGateway.getAllPolicies();
        if (Objects.nonNull(policies)) {
            policyMap = policies.stream().collect(Collectors.toMap(Policy::getSid, p -> p));
        }
        log.info("Loaded cache from policy server");
    }

    @Cacheable(value = "policyCache")
    public Policy getPolicy(String sid) {
        log.info("Retrieving policy for sid {}", sid);
        return policyMap.get(sid);
    }
}
