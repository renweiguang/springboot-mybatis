package com.rwg.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;

import javax.xml.bind.SchemaOutputResolver;

@Aspect
@Component
public class BrokerQAspect {
    /**
     * 定义切入点，切入点为com.xyj.controller.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.rwg.controller.AopController.*(..)))")

    public void BrokerAspect() {
    }


    @Pointcut("execution(public * com.rwg.controller.AopController.*(..)))")

    public void BrokerAspect1() {
    }

    /**
     * @description 在连接点执行之前执行的通知
     */
    @Before("BrokerAspect() || BrokerAspect1()")
    public void doBeforeGame(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);


        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println("经纪人正在处理球星赛前事务！");
        System.out.println("经 纪人正在处理球星赛前事务！");
    }

    /**
     * @description 在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerAspect()")
    public void doAfterGame() {
        System.out.println("经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description 在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("BrokerAspect()")
    public void doAfterReturningGame() {
        System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description 在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("BrokerAspect()")
    public void doAfterThrowingGame() {
        System.out.println("异常通知：球迷要求退票！");
    }
}
