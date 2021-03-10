package io.renren.common.utils;

import lombok.Data;

@Data
public class BaiduIpUtilsModeResult {
    private String nation;
    private String en_short;
    private String en_name;
    private String province;
    private String city;
    private String district;
    private String adcode;
    private double lat;
    private double lng;

        public  String getAddress() {
        return this.province + this.city + this.district;
    }
}
