package io.renren.common.utils;
import com.alibaba.fastjson.JSON;
import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;
public class BaiduIpUtils {
    public static BaiduIpUtilsMode Query(String ip){
        String path = "http://gwgp-hrtx4zoqeyk.n.bdcloudapi.com/iplocaltion";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.GET, path);
        request.setCredentials("fd27391561f4407c88f5cba7f4cba873", "2cffd74857394a8f85d25c6085529995");
        //request.setCredentials("fd27391561f4407c88f5cba7f4cba878", "2cffd74857394a8f85d25c6085529995");

        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");

        request.addQueryParameter("ip", ip);



        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());
        BaiduIpUtilsMode baiduIpUtilsMode=new BaiduIpUtilsMode();
        try {
            ApiExplorerResponse response = client.sendRequest(request);
            // 返回结果格式为Json字符串
            //System.out.println(response.getResult());
            baiduIpUtilsMode= JSON.parseObject(response.getResult(),BaiduIpUtilsMode.class);
            return baiduIpUtilsMode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baiduIpUtilsMode;
    }
}
