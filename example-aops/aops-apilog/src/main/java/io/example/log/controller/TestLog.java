package io.example.log.controller;

import com.detabes.apilog.annotation.ApiLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tn
 * @version 1
 * @ClassName TestLog
 * @description 测试 io开头的报名
 * @date 2020/12/21 12  :04
 */
@RestController
public class TestLog {
    /**
     * 接口记录 - 只有日志打印功能
     * 测试 io开头的报名
     */
    @GetMapping("/testApiLogAspectSeeIo")
    public String testApiLogAspectSeeIo() {
        return "接口记录 - 测试 io开头的报名";
    }

}
