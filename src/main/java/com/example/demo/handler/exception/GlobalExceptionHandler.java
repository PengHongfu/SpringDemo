package com.example.demo.handler.exception;

import com.example.demo.web.AreaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * Created by PengHongfu 2018-05-28 18:14
 */
//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /*当页面请求地址映射不存在时，如 area/aaaa,前置控制器dispatcherServlet,会自动映射/error，或者是error资源
     * This application has no explicit mapping for /error
     */
    public static final String DEFAULT_ERROR_VIEW = "errorMsg";


    /*跳转到错误页面*/
    @ExceptionHandler(value = MyException.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, MyException e) {
        logger.info("错误信息：{}",e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
    /*捕获错误返回格式化的数据*/
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", false);
        modelMap.put("reeMsg", e.getMessage());
        return modelMap;
    }

}
