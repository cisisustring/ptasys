package io.renren.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.app.dao.BusinesslogDao;
import io.renren.modules.app.entity.BusinesslogEntity;
import io.renren.modules.app.service.BusinesslogService;


@Service("businesslogService")
public class BusinesslogServiceImpl extends ServiceImpl<BusinesslogDao, BusinesslogEntity> implements BusinesslogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinesslogEntity> page = this.page(
                new Query<BusinesslogEntity>().getPage(params),
                new QueryWrapper<BusinesslogEntity>()
        );

        return new PageUtils(page);
    }

}