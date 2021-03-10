package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.CognitiveMagicScaleEntity;
import io.renren.modules.sys.service.CognitiveMagicScaleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-12-17 13:39:05
 */
@RestController
@RequestMapping("sys/cognitivemagicscale")
public class CognitiveMagicScaleController {
    @Autowired
    private CognitiveMagicScaleService cognitiveMagicScaleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:cognitivemagicscale:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cognitiveMagicScaleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:cognitivemagicscale:info")
    public R info(@PathVariable("id") Long id){
		CognitiveMagicScaleEntity cognitiveMagicScale = cognitiveMagicScaleService.getById(id);

        return R.ok().put("cognitiveMagicScale", cognitiveMagicScale);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:cognitivemagicscale:save")
    public R save(@RequestBody CognitiveMagicScaleEntity cognitiveMagicScale){
		cognitiveMagicScaleService.save(cognitiveMagicScale);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:cognitivemagicscale:update")
    public R update(@RequestBody CognitiveMagicScaleEntity cognitiveMagicScale){
		cognitiveMagicScaleService.updateById(cognitiveMagicScale);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:cognitivemagicscale:delete")
    public R delete(@RequestBody Long[] ids){
		cognitiveMagicScaleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
