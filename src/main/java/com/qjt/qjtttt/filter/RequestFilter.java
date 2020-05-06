package com.qjt.qjtttt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Calendar;

@WebFilter
@Configuration
@Order(3)//值越大优先级越大
public class RequestFilter implements Filter {

    private Logger logger=LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("参数初始化:"+filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("RequestFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        // 设置限制运行时间
        if (0<hour && hour < 18) {
            logger.info("在0-18时之间");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

        logger.info("destroy");
    }
}
