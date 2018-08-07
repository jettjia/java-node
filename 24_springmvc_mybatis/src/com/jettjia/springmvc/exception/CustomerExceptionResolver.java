package com.jettjia.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
            Exception exception) {
        // 定义异常信息
        String msg;
        // 判断异常类型
        if (exception instanceof MyException) {
            // 如果是自定义异常，读取异常信息
            msg = exception.getMessage();
        } else {
            // 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            exception.printStackTrace(s);
            msg = out.toString();
        }
        // 把错误信息发给相关人员，邮件、短信等方式
        // TODO
        
        // 返回错误页面，给用户友好提示错误信息
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", msg);
        mav.setViewName("error");
        return mav;
    }

}
