package com.iceberry.starterDemo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLogInterceptor implements HandlerInterceptor {
    private static final Logger logger= LoggerFactory.getLogger(RequestLogInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("{} {} {} {}",
                request.getMethod(),
                response.getStatus(),
                request.getRemoteAddr(),
                request.getRequestURI());
    }
}
