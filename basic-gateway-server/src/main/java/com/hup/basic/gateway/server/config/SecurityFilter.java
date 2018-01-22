package com.hup.basic.gateway.server.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class SecurityFilter extends ZuulFilter {
    //过滤器类型
    @Override
    public String filterType() {
        return null;
    }

    //过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断该过滤器是否需要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器执行的具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }
        return null;
    }
}
