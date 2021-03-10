package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CognitiveMagicScaleEntity;

import java.util.Map;

/**
 * 
 *
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-12-17 13:39:05
 */
public interface CognitiveMagicScaleService extends IService<CognitiveMagicScaleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

