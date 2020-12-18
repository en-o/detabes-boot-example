package com.example.result;

import com.detabes.result.page.ResourcePage;
import com.detabes.result.result.ResultVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller("/")
public class ApiResultApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiResultApplication.class, args);
    }


    /**
     * 普通返回
     * @return
     */
    @GetMapping("/testResultVO")
    @ResponseBody
    public ResultVO<String> testResultVO(){
        return ResultVO.success("hi result");
    }

    /**
     * 分页返回
     * @return
     */
    @GetMapping("/testResultVO_Page")
    @ResponseBody
    public ResultVO<String> testResultVO_Page(){
        ResourcePage page = new ResourcePage();
        return ResultVO.success("hi result",page);
    }
}
