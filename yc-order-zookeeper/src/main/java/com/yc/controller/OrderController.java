package com.yc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 10:21
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 通过服务名获取服务调用地址
     * @param name
     * @return
     */
    public String getServiceUrl(String name){
        List<ServiceInstance> list = discoveryClient.getInstances(name);
        if(list != null && list.size() > 0){
            return list.get(0).getUri().toString();
        }
        return null;
    }

    /**
     * 调用Zookeeper注册中心的会员服务
     * @return
     */
    @GetMapping("/getOrder")
    public String getOrder(){
        String serviceUrl = getServiceUrl("zk-member")+"/getMember";
        String ret = restTemplate.getForObject(serviceUrl, String.class);
        System.out.print("zookeeper注册中心调用会员服务");
        return ret;
    }
}
