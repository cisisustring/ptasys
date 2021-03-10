package io.renren.modules.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import io.renren.common.utils.BaiduIpUtils;
import io.renren.common.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.CognitiveMagicScaleEntity;
import io.renren.modules.sys.service.CognitiveMagicScaleService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-12-17 13:47:54
 */
@RestController
@RequestMapping("app/cognitivemagicscaleapp")
public class CognitiveMagicScaleappController {
    @Autowired
    private CognitiveMagicScaleService cognitiveMagicScaleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("app:cognitivemagicscale:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = cognitiveMagicScaleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("app:cognitivemagicscale:info")
    public R info(@PathVariable("id") Long id) {
        CognitiveMagicScaleEntity cognitiveMagicScale = cognitiveMagicScaleService.getById(id);

        return R.ok().put("cognitiveMagicScale", cognitiveMagicScale);
    }

    /**
     * 保存
     *//*
    @RequestMapping("/save")
    //@RequiresPermissions("app:cognitivemagicscale:save")
    public R save(@RequestBody CognitiveMagicScaleEntity cognitiveMagicScale,HttpServletRequest request){
        //String username=request.getParameter("username");
        String Recommender=request.getParameter("recommender");
        //String create_time=request.getParameter("create_time");
        String ip_address= IPUtils.getIpAddr(request);
        //设置正确的推荐人和ip地址
        cognitiveMagicScale.setRecommender(Recommender);
        cognitiveMagicScale.setIpAddress(ip_address);
		cognitiveMagicScaleService.save(cognitiveMagicScale);

        return R.ok();
    }*/

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("app:cognitivemagicscale:save")
    public R save(@RequestParam(value = "recommender", required = false, defaultValue = "nobody") String Recommender
            , String username
            , String createTime
            , Integer i1
            , Integer i2
            , Integer i3
            , Integer i4
            , Integer i5
            , Integer i6
            , Integer i7
            , Integer i8
            , Integer extroversion
            , Integer diffidence
            , Integer reason
            , Integer sensibility
            , Integer behavior
            , Integer consider
            , Integer intellect
            , Integer initiate
            , Integer organization
            , Integer emotion
            , HttpServletRequest request) {
        CognitiveMagicScaleEntity cognitiveMagicScale = new CognitiveMagicScaleEntity();
        String ip_address = IPUtils.getClientIP(request);
        //加入"|"+QueryHelper.queryIP("8.8.8.8");地址解析
        /*String queryedip_address =QueryHelper.queryIP(ip_address);
        ip_address= queryedip_address.length()>ip_address.length()?queryedip_address:ip_address;*/
        //加入百度ip查询接口BaiduIpUtils.Query("183.219.65.216").getResult().getAddress()
        String queryedip_address = BaiduIpUtils.Query(ip_address).getResult().getAddress();
        ip_address= queryedip_address.isEmpty()?ip_address:queryedip_address;
        String useragent = request.getHeader("User-Agent");
        useragent = useragent.substring(13, useragent.indexOf(")"));
        //设置正确的推荐人和ip地址
        cognitiveMagicScale.setRecommender(Recommender);
        cognitiveMagicScale.setIpAddress(ip_address);
        cognitiveMagicScale.setUsername(username);
        cognitiveMagicScale.setCreateTime(createTime);
        cognitiveMagicScale.setI1(i1);
        cognitiveMagicScale.setI2(i2);
        cognitiveMagicScale.setI3(i3);
        cognitiveMagicScale.setI4(i4);
        cognitiveMagicScale.setI5(i5);
        cognitiveMagicScale.setI6(i6);
        cognitiveMagicScale.setI7(i7);
        cognitiveMagicScale.setI8(i8);
        cognitiveMagicScale.setExtroversion(extroversion);
        cognitiveMagicScale.setDiffidence(diffidence);
        cognitiveMagicScale.setReason(reason);
        cognitiveMagicScale.setSensibility(sensibility);
        cognitiveMagicScale.setBehavior(behavior);
        cognitiveMagicScale.setConsider(consider);
        cognitiveMagicScale.setIntellect(intellect);
        cognitiveMagicScale.setInitiate(initiate);
        cognitiveMagicScale.setOrganization(organization);
        cognitiveMagicScale.setEmotion(emotion);
        cognitiveMagicScale.setUseragent(useragent);
        cognitiveMagicScaleService.save(cognitiveMagicScale);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("app:cognitivemagicscale:update")
    public R update(@RequestBody CognitiveMagicScaleEntity cognitiveMagicScale) {
        cognitiveMagicScaleService.updateById(cognitiveMagicScale);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("app:cognitivemagicscale:delete")
    public R delete(@RequestBody Long[] ids) {
        cognitiveMagicScaleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}

class QueryHelper {

    /**
     * txt|jsonp|xml
     */
    public static String DATATYPE = "text";

    public static String get(String urlString, String token) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(5 * 1000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("token", token);
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                StringBuilder builder = new StringBuilder();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                for (String s = br.readLine(); s != null; s = br
                        .readLine()) {
                    builder.append(s);
                }
                br.close();
                return builder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String queryIP(String ip) {
        String url = "https://api.ip138.com/ip/?ip=" + ip + "&datatype=" + DATATYPE;
        String token = "cda8948f8d9a668927283c30d5d5206a";
        return get(url, token);
    }
}

//以下是使用示例：
//QueryHelper.queryIP("8.8.8.8");
