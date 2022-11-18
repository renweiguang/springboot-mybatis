package com.rwg.globalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author renwg
 * @date 2022/11/18
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e) {
        log.error(e.getErrorMsg(), e);
        return AjaxResult.defineError(e);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}