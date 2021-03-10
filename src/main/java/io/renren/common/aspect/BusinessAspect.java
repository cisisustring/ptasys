package io.renren.common.aspect;

import com.google.gson.Gson;
import io.renren.common.utils.HttpContextUtils;
import io.renren.common.utils.IPUtils;
import io.renren.modules.app.entity.BusinesslogEntity;
import io.renren.modules.app.service.BusinesslogService;
import org.apache.commons.lang.ObjectUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class BusinessAspect {

    //引入日志的service接口
    @Autowired
    BusinesslogService businesslogServiceImpl;

    //开始Around
    @Around("execution(* *..app.controller..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        //请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();


        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        String Userip = IPUtils.getIpAddr(request);

        //获取用户其他参数

        String header = request.getHeader("User-Agent");
        String Ruri = request.getRequestURI();
        String Rurl = ObjectUtils.toString(request.getRequestURL());
        String Qmethod = request.getMethod();
        String Gdomain = HttpContextUtils.getDomain();
        BusinesslogEntity businesslogEntity = new BusinesslogEntity();
        businesslogEntity.setClassname(className);
        businesslogEntity.setTime(time);
        businesslogEntity.setMethodname(methodName);
        businesslogEntity.setUserip(Userip);

        businesslogEntity.setUseragent(header);
        businesslogEntity.setUri(Ruri);
        businesslogEntity.setUrl(Rurl);
        businesslogEntity.setMethod(Qmethod);
        businesslogEntity.setDomain(Gdomain);
        businesslogEntity.setCreated(new Date().getTime());
        //请求的参数
        Object[] args = point.getArgs();
        try {
            try {
                Long userid = Long.parseLong(request.getAttribute("userId").toString());
                businesslogEntity.setUserId(userid);
            } catch (Exception e) {

            }
            try {
                String params = new Gson().toJson(args);
                businesslogEntity.setParams(params);
            } catch (Exception e) {

            }

        } catch (Exception e) {

        }
        businesslogServiceImpl.save(businesslogEntity);
        return result;
    }


}
