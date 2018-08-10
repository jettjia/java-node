package com.jettjia.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    
    // controller执行后且视图返回后调用此方法
    // 可得到执行controller时的异常信息
    // 这里可以处理异常，清理资源，记录日志等等
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("HandlerInterceptor.afterCompletion is run");
    }
    
    // controller执行后，但是未返回视图前调用此方法
    // 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示，比如公共导航
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("HandlerInterceptor.postHandle is run");
    }
    
    // controller执行前调用
    // 返回true表示继续执行，返回false终止执行
    // 这里可以加入等量校验，权限拦截等
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        System.out.println("HandlerInterceptor.preHandle is run");
        // 设置为true，测试使用
        return true;
    }

}
