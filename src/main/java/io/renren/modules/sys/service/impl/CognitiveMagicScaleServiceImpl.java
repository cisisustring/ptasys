package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.CognitiveMagicScaleDao;
import io.renren.modules.sys.entity.CognitiveMagicScaleEntity;
import io.renren.modules.sys.service.CognitiveMagicScaleService;


@Service("cognitiveMagicScaleService")
public class CognitiveMagicScaleServiceImpl extends ServiceImpl<CognitiveMagicScaleDao, CognitiveMagicScaleEntity> implements CognitiveMagicScaleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        IPage<CognitiveMagicScaleEntity> page = this.page(
                new Query<CognitiveMagicScaleEntity>().getPage(params),
                new QueryWrapper<CognitiveMagicScaleEntity>()
        );

        return new PageUtils(page);
    }

}