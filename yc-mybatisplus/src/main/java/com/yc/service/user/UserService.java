package com.yc.service.user;

import com.yc.common.CommonResult;
import com.yc.entity.user.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台管理用户表 服务类
 * </p>
 *
 * @author yiChenLove
 * @since 2020-06-06
 */
public interface UserService extends IService<User> {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
