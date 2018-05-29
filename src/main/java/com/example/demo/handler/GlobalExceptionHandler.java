package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * Created by PengHongfu 2018-05-28 18:14
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("reeMsg",e.getMessage());
        return modelMap;
    }

}
