package com.xdlx.service.java.nosql.aop;


import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import com.xdlx.service.java.nosql.annotations.AnRateLimiter;
import com.xdlx.service.java.nosql.util.ResponseUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class RateLimitAop {

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 使用url做为key,存放令牌桶 防止每次重新创建令牌桶
     */
    private Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    @Pointcut("@annotation(com.xdlx.service.java.nosql.annotations.AnRateLimiter)")
    public void anRateLimiter() {
    }

    @Around("anRateLimiter()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取request,response
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        // 或者url(存在map集合的key)
        String url = request.getRequestURI();
        // 获取自定义注解
        AnRateLimiter rateLimiter = getAnRateLimiter(joinPoint);
        if (rateLimiter != null) {
            RateLimiter limiter = null;
            // 判断map集合中是否有创建有创建好的令牌桶
            if (!limitMap.containsKey(url)) {
                // 创建令牌桶
                limiter = RateLimiter.create(rateLimiter.permitsPerSecond());
                limitMap.put(url, limiter);
                logger.info("<<=================  请求{},创建令牌桶,容量{} 成功!!!", url, rateLimiter.permitsPerSecond());
            }
            limiter = limitMap.get(url);
            // 获取令牌
            boolean acquire = limiter.tryAcquire(rateLimiter.timeout(), rateLimiter.timeunit());

            if (!acquire) {
                ResponseUtil.responseResult(response, 500, rateLimiter.msg());
                return null;
            }
        }
        return joinPoint.proceed();
    }

    /**
     * 获取注解对象
     * @param joinPoint 对象
     * @return ten LogAnnotation
     */
    private AnRateLimiter getAnRateLimiter(final JoinPoint joinPoint) {
        Method[] methods = joinPoint.getTarget().getClass().getDeclaredMethods();
        String name = joinPoint.getSignature().getName();
        if (!StringUtils.isEmpty(name)) {
            for (Method method : methods) {
                AnRateLimiter annotation = method.getAnnotation(AnRateLimiter.class);
                if (!Objects.isNull(annotation) && name.equals(method.getName())) {
                    return annotation;
                }
            }
        }
        return null;
    }
}
