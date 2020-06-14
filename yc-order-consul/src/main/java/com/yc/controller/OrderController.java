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
 * @date 2020/6/13 0013 15:51
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 根据服务名称获取服务地址，需要跟consul中注入的服务名一样
     * @param name
     * @return
     */
    public String getServiceUrl(String name){
        List<ServiceInstance> list= discoveryClient.getInstances(name);
        if(list != null && !list.isEmpty()){
            return list.get(0).getUri().toString();
        }
        return null;
    }

    /**
     * 订单服务调用会员服务
     * @return
     */
    @GetMapping("/getOrder")
    public String getOrder(){
        // 有两种方式，一种是采用服务别名方式调用，另一种是直接调用 使用别名去注册中心上获取对应的服务调用地址
        String serviceUrl = getServiceUrl("yc-member-consul")+"/getMember";
        String ret = restTemplate.getForObject(serviceUrl, String.class);
        System.out.println("订单服务调用会员服务result:" + ret);
        return ret;
    }
}
