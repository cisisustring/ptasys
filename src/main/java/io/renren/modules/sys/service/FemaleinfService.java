package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.FemaleinfEntity;

import java.util.Map;

/**
 * 
 *
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-11-21 15:15:06
 */
public interface FemaleinfService extends IService<FemaleinfEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

