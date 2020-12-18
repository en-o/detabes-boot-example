package com.example.exception;

import com.detabes.enums.result.ResultCodeEnum;
import com.detabes.exception.exception.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller("/")
public class ApisExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApisExceptionApplication.class, args);
    }


    /**
     * 测试全局异常示例
     * @return
     */
    @GetMapping("/testException")
    @ResponseBody
    public void testException() {
        System.out.println("hi exception");
        System.out.println("1/0 = " + 1 / 0);
    }

    /**
     * 自定义异常效果示例
     * @return
     */
    @GetMapping("/testBusinessException")
    @ResponseBody
    public void testBusinessException() {
        System.out.println("hi businessException");
        throw  new BusinessException(ResultCodeEnum.SysError);
    }
}
