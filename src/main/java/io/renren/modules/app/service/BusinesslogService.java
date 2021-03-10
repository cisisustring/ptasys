package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.BusinesslogEntity;

import java.util.Map;

/**
 * 
 *
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-11-19 17:32:54
 */
public interface BusinesslogService extends IService<BusinesslogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

