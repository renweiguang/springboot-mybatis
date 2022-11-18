package com.rwg.interceptor;

import com.rwg.annotation.AppUserInfo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Package: com.*.*.interceptor
 * @ClassName: AdminInterceptor
 * @Description:拦截器
 * @author: rwg
 * @date: 2019年9月19日 下午2:20:57
 */

public class AdminInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）****测试提交记录****
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AppUserInfo annotation = handlerMethod.getMethodAnnotation(AppUserInfo.class);
            if (Objects.nonNull(annotation)) {
                boolean autoRegister = annotation.isAutoRegister();
                boolean mustGetUserInfo = annotation.isMustGetUserInfo();
                System.out.println(autoRegister);
                System.out.println(mustGetUserInfo);
            }
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        System.out.println("执行了TestInterceptor的postHandle方法");
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("执行了TestInterceptor的afterCompletion方法");
    }

}