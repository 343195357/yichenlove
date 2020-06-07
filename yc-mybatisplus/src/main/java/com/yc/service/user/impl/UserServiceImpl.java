package com.yc.service.user.impl;

import cn.hutool.core.util.StrUtil;
import com.yc.common.CommonResult;
import com.yc.entity.user.User;
import com.yc.dao.user.UserMapper;
import com.yc.service.base.RedisService;
import com.yc.service.user.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * 后台管理用户表 服务实现类
 * </p>
 *
 * @author yiChenLove
 * @since 2020-06-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer sb = new StringBuffer();
        Random rd = new Random();
        for(int i =0 ; i < 6; i++){
            sb.append(rd.nextInt(10));
        }
        //验证码绑定手机号存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone, sb.toString());
        //设置验证码过期时间
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success("获取验证码成功：",sb.toString());
    }

    /**
     * 对输入的验证码进行校验
     * @param telephone
     * @param authCode
     * @return
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StrUtil.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        if(StrUtil.equals(authCode, realAuthCode)){
            return CommonResult.success("验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }
    }
}
