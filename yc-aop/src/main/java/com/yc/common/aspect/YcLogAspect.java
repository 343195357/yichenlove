package com.yc.common.aspect;

import com.yc.common.annotation.YcLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义日志切面
 * @Author YichenLove
 * @Date 2020/6/15
 **/
@Aspect
@Component
public class YcLogAspect {
    private static final Logger log = LoggerFactory.getLogger(YcLogAspect.class);

    /*
     *配置切入点
     * 里面可以配置成"execution(* com.xiaojukeji..*.*(..)) && @annotation(com.yc.common.annotation.YcLog)"
     * 扫描com.xiaojukeji包及此包下的所有带有YcLog注解的方法
     */
    @Pointcut("@annotation(com.yc.common.annotation.YcLog)")
    public void logPointCut(){

    }

    /**
     * 前置通知 用于拦截操作
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint)
    {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e);
    }

    /**
     * 处理日志信息
     * @param joinPoint
     * @param e
     */
    protected void handleLog(final JoinPoint joinPoint, final Exception e)
    {
        try
        {
            //获取方法上日志注解的参数对象
            YcLog ycLog = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(YcLog.class);
            // *========开始记录数据库日志=========*//
            if (e != null)
            {
                //如果存在异常，则获取异常信息
                log.error("发生异常信息："+e.getMessage());
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            log.info("当前调用的方法为：",className + "." + methodName + "()");
            Object[] params = joinPoint.getArgs();
            log.info("当前调用方法参数：", params);
            // 保存数据库
            log.info("日志存入数据库："+ycLog.toString());
        }
        catch (Exception exp)
        {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

}
