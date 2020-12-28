package com.example.detabes.boot.web.controller;

import com.detabes.annotation.mapping.PathRestController;
import com.detabes.enums.result.ResultCodeEnum;
import com.detabes.exception.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tn
 * @version 1
 * @ClassName ExceptionController
 * @description 异常测试
 * @date 2020/12/28 12:59
 */
@Api(tags = "异常测试")
@PathRestController("exception")
public class ExceptionController {
    /**
     * 测试全局异常示例
     * @return
     */
    @GetMapping("/testException")
    @ApiOperation("测试全局异常示例")
    public void testException() {
        System.out.println("hi exception");
        System.out.println("1/0 = " + 1 / 0);
    }

    /**
     * 自定义异常效果示例
     * @return
     */
    @GetMapping("/testBusinessException")
    @ApiOperation("自定义异常效果示例")
    public void testBusinessException() {
        System.out.println("hi businessException");
        throw  new BusinessException(ResultCodeEnum.SysError);
    }


    /**
     * 自定义异常效果示例 只传message
     * @return
     */
    @GetMapping("/testBusinessExceptionByMessage")
    @ApiOperation("自定义异常效果示例 只传message")
    public void testBusinessExceptionByMessage() {
        System.out.println("hi businessException");
        throw  new BusinessException("自定义异常效果示例 只传message");
    }
}
