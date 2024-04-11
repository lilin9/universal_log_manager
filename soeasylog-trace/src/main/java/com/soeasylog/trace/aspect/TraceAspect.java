package com.soeasylog.trace.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

/**
 * className：TraceAspect
 * description：
 * time：2020-05-09.14:34
 */
@Aspect
@Component
@ConditionalOnMissingBean(value = AbstractAspect.class, ignored = TraceAspect.class)
public class TraceAspect extends AbstractAspect {
    @Around("@annotation(com.soeasylog.trace.annotation.Trace))")
    public Object around(JoinPoint joinPoint) throws Throwable {
        return aroundExecute(joinPoint);
    }
}
