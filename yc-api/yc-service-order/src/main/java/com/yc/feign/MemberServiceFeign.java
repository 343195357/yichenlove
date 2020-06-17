package com.yc.feign;

import com.yc.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/14 0014 18:46
 */
@FeignClient(name = "yc-member-feign")
public interface MemberServiceFeign extends IMemberService {
}
