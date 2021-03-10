package io.renren.modules.app.service.impl;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.LoginidentifycodeDao;
import io.renren.modules.app.entity.LoginidentifycodeEntity;
import io.renren.modules.app.service.LoginidentifycodeService;


@Service("loginidentifycodeService")
public class LoginidentifycodeServiceImpl extends ServiceImpl<LoginidentifycodeDao, LoginidentifycodeEntity> implements LoginidentifycodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LoginidentifycodeEntity> page = this.page(
                new Query<LoginidentifycodeEntity>().getPage(params),
                new QueryWrapper<LoginidentifycodeEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 校验短信验证码，并且每次验证都要在loginidentifycode的tries上+1，
     * 如果tries>5,则校验不通过，并且提示验证码超过次数限制，请申请新的验证码
     */
    @Override
    public boolean checkidentifcode(String code, String mobile,int type) {
        if (this.count(new QueryWrapper<LoginidentifycodeEntity>().eq("phone", mobile).eq("type",type)) == 0) {
            throw new RRException("请先申请短信验证码");
        }
        LoginidentifycodeEntity loginidentifycodeEntity = this.list(new QueryWrapper<LoginidentifycodeEntity>().eq("phone", mobile).eq("type",type).orderByDesc("id")).get(0);
        int tries = loginidentifycodeEntity.getTries();
        loginidentifycodeEntity.setTries(++tries);
        this.updateById(loginidentifycodeEntity);
        if (!loginidentifycodeEntity.getCode().equals(code)||loginidentifycodeEntity.getTries() > 5) {
            return false;
        } else {
            return true;
        }
    }

}