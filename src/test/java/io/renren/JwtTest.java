package io.renren;

import io.renren.common.utils.BaiduIpUtils;
import io.renren.common.utils.Constant;
import io.renren.modules.app.service.LoginidentifycodeService;
import io.renren.modules.app.utils.JwtUtils;
import io.renren.modules.sys.service.SysCaptchaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.renren.modules.app.controller.CognitiveMagicScaleappController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private SysCaptchaService sysCaptchaServiceImpl;
    @Autowired
    LoginidentifycodeService loginidentifycodeServiceImpl;
    @Test
    public void test() {
        String token = jwtUtils.generateToken(1);

        System.out.println(token);
    }
    @Test
    public void testCaptcha(){
        String uuid="745.1546854";
        String code="me2am";
        System.out.println("图形验证码测试结果是： "+sysCaptchaServiceImpl.validate(uuid,code));
    }
    @Test
    public void testLoginidentifycodeService(){
        System.out.println("短信校验码测试结果是： "+loginidentifycodeServiceImpl.checkidentifcode("6666","13888888888", Constant.register_type));
    }
    @Test
    public void testint(){
        int a=3;
        int b=1+2;
        int a300=300;
        int b300=100+200;
        System.out.print("a==b: ");
        System.out.println(a==b);
        System.out.print("a300==b300: ");
        System.out.println(a300==b300);
    }
    @Test
    public void testQueryHelper(){
        System.out.println(BaiduIpUtils.Query("128.199.185.192").getResult().getAddress());
    }
    @Test
    public void testQueryHelperImpl(){
        System.out.println(BaiduIpUtils.Query("128.199.185.192").getResult().getAddress());
    }
}
