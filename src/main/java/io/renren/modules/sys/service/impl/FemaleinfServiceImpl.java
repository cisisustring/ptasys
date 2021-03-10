package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.FemaleinfDao;
import io.renren.modules.sys.entity.FemaleinfEntity;
import io.renren.modules.sys.service.FemaleinfService;


@Service("femaleinfService")
public class FemaleinfServiceImpl extends ServiceImpl<FemaleinfDao, FemaleinfEntity> implements FemaleinfService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String company = (String) params.get("company");
        Integer age =  params.get("age").toString().isEmpty()?0:Integer.parseInt(params.get("age").toString());
        IPage<FemaleinfEntity> page = this.page(
                new Query<FemaleinfEntity>().getPage(params),
                new QueryWrapper<FemaleinfEntity>().lambda()
                        .like(FemaleinfEntity::getCompany, company)
                        .eq(age>0,FemaleinfEntity::getAge, age)

                //.like("company",company)
        );

        return new PageUtils(page);
    }

}