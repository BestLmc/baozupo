package com.baozupo.admin.aspect;


import com.baozupo.common.annotion.keyword.Length;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author bestlmc
 * @Date 2022/3/20 17:01
 */
@Aspect
@Component
public class LengthAspect {

    // @Pointcut("execution(public * com.test.my.annotation.TestController.*(..)) && @annotation(com.test.my.annotation.MyAnnotation)" )
//    @Pointcut("@annotation(com.bestlmc.lihuamao.commons.annotion.keyword.Length)" )
    @Pointcut("@annotation(com.baozupo.common.annotion.keyword.Length)" )
    public void addAdvice(){}

    @Around("addAdvice()")
    public Object arround(ProceedingJoinPoint joinPoint){
        System.out.println("====Interceptor====");
        System.out.println("通知之开始");
        Object retmsg=null;
        try {
            retmsg = joinPoint.proceed();
            System.err.println("++++++++"+retmsg);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("通知之结束 +retmsg+" + retmsg);

        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
    @Before("addAdvice()")
    public void before(JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        Length annotation = method.getAnnotation(Length.class);
        System.out.println("打印：" + annotation.message() + " 开始前");
        //System.out.println("===开始前===");
    }

    @After("addAdvice()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after方法执行后");

//        Object[] args = joinPoint.getArgs();


    }







}
