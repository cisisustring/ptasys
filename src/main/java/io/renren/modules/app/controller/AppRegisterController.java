/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.modules.app.controller;


import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.common.utils.StringUtil;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.form.RegisterForm;
import io.renren.modules.app.service.LoginidentifycodeService;
import io.renren.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginidentifycodeService loginidentifycodeServiceImpl;
    /**
     * 注册按需要增加一个验证码发送环节
     * @param form
     * @return
     */
    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);
        if (StringUtils.isBlank(form.getMobile()) | StringUtils.isBlank(form.getPassword())) {
            throw new RRException("手机号码或者密码不能为空");
        }
        if (StringUtil.phone_rule(form.getMobile()).equals("error")) {
            throw new RRException("请输入真实手机号码");
        }
        if (form.getMobile().length() != 11) {
            throw new RRException("请输入11位手机号码");
        }
        if (form.getPassword().length() <= 6) {
            throw new RRException("请输入6位以上密码");
        }
        if(userService.queryByMobile(form.getMobile())!= null){
            throw new RRException("手机号码已注册");
        }
        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.save(user);

        return R.ok("恭喜注册成功");
    }
    /**
     * 忘记密码，修改密码,需要发送验证码
     */

    /**
     * 已经登录的情况下直接修改密码，提交token和旧密码，新密码即可
     */

    /**
     * 添加日志，参考_log.info(request.getRequestURL()+"?"+request.getQueryString());
     */
}
