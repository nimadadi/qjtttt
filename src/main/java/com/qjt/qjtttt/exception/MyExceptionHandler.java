package com.qjt.qjtttt.exception;

import com.qjt.qjtttt.model.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//        全局异常处理
//        全局数据绑定
//        全局数据预处理
@ControllerAdvice
public class MyExceptionHandler  {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public  BaseResponse bizExceptionHandler(HttpServletRequest req, MyException e){
        logger.error("发生业务异常！原因是：{}",e);
        return new BaseResponse(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return BaseResponse.error(CommonEnum.NOT_FOUND.getResultCode(),CommonEnum.NOT_FOUND.getResultMsg());
    }


    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public BaseResponse exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return BaseResponse.error(CommonEnum.INTERNAL_SERVER_ERROR.getResultCode(),CommonEnum.INTERNAL_SERVER_ERROR.getResultMsg());
    }

}
