package com.example.detabes.boot.web.controller;

import com.detabes.annotation.mapping.PathRestController;
import com.detabes.apilog.annotation.ApiLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tn
 * @version 1
 * @ClassName TestLog
 * @description 测试接口日志
 * @date 2020/12/21 12  :04
 */
@PathRestController("api")
@Api(tags = "测试接口日志")
public class ApiLogController {
    /**
     * 接口记录 - 只有日志打印功能
     */
    @GetMapping("/testApiLogAspectSee")
    @ApiOperation("接口记录 - 只有日志打印功能")
    public String testApiLogAspectSee() {
        return "接口记录 - 只有日志打印功能";
    }


    /**
     * 接口记录保存 - 可以打印日志可以报错日志，看你怎么选择
     */
    @GetMapping("/testApiLogAspectSave")
    @ApiLog
    @ApiOperation("接口记录保存 - 可以打印日志可以报错日志，看你怎么选择")
    public String testApiLogAspectSave() {
        return "hi: 接口记录保存 - 可以打印日志可以报错日志，看你怎么选择";
    }

}
