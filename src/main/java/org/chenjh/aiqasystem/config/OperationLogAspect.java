package org.chenjh.aiqasystem.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.chenjh.aiqasystem.service.system.LogService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Aspect
@Component
@Slf4j
public class OperationLogAspect {

    private final LogService logService;

    public OperationLogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(org.chenjh.aiqasystem.config.OperationLog)")
    public void logPointCut() {}

    @Around("logPointCut() && @annotation(operationLog)")
    public Object logAround(ProceedingJoinPoint joinPoint, OperationLog operationLog) throws Throwable {
        // 获取操作描述信息
        String operationDescription = operationLog.value();
        // 获取方法的参数
        Object[] args = joinPoint.getArgs();
        String argsString = Arrays.toString(args);
        // 获取操作者用户名（假设使用 Spring Security）
        String username = "测试";
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
        // 获取请求的方法信息
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        // 记录操作之前的信息
        log.info("操作开始: {}", operationDescription);

        Object result;
        long startTime = System.currentTimeMillis();
        try {
            // 执行目标方法
            result = joinPoint.proceed();
        } catch (Exception e) {
            logService.saveOperationLog(operationDescription, className + "." +methodName, argsString, username, -1);
            throw e;
        }

        long timeTaken = System.currentTimeMillis() - startTime;
        // 记录操作之后的信息
        log.info("操作完成: {}, 耗时: {} ms", operationDescription, timeTaken);
        logService.saveOperationLog(operationDescription,className + "." +methodName, argsString, username, timeTaken);
        return result;
    }
}
