package com.example.log.controller;

import com.detabes.apilog.annotation.ApiLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tn
 * @version 1
 * @ClassName TestLog
 * @description 测试
 * @date 2020/12/21 12  :04
 */
@RestController
public class TestLog {
    /**
     * 接口记录 - 只有日志打印功能
     */
    @GetMapping("/testApiLogAspectSee")
    public String testApiLogAspectSee() {
        return "接口记录 - 只有日志打印功能";
    }


    /**
     * 接口记录保存 - 可以打印日志可以报错日志，看你怎么选择
     */
    @GetMapping("/testApiLogAspectSave")
    @ApiLog
    public String testApiLogAspectSave() {
        return "hi: 接口记录保存 - 可以打印日志可以报错日志，看你怎么选择";
    }

}
