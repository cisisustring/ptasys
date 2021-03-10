package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.LoginidentifycodeEntity;

import java.util.Map;

/**
 * 
 *
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-11-17 22:44:46
 */
public interface LoginidentifycodeService extends IService<LoginidentifycodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 校验短信验证码，并且每次验证都要在loginidentifycode的tries上+1，
     * 如果tries>5,则校验不通过，并且提示验证码超过次数限制，请申请新的验证码
     */
    boolean checkidentifcode(String code,String mobile,int type);
}

