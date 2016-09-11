package com.pengjinfei.ch4.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        Long endTime= System.currentTimeMillis();
        logger.info("本次请求处理时间为:"+new Long(endTime-startTime)+"ms.");
        request.setAttribute("handlingTIme",endTime-startTime);
    }
}
