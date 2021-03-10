package io.renren.common.utils;

import lombok.Data;

/**
 * 接收百度ip查询结果的，成功的话code==100,其他的code都是失败
 */
@Data
public class BaiduIpUtilsMode {
    private int code;
    private String message;
    private String ip;
    private BaiduIpUtilsModeResult result;


}

