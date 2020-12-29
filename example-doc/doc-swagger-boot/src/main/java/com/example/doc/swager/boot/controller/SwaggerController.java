package com.example.doc.swager.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tn
 * @version 1
 * @ClassName SwaggerController
 * @description 测试swaggger接口文档
 * @date 2020/12/22 15:12
 */
@RestController
@RequestMapping("swagger")
@Api(tags = "测试swaggger接口文档")
public class SwaggerController {

    @GetMapping("/getMethod")
    @ApiOperation(value = "测试接口1", notes = "测试swaggger接口文档")
    public String getMethod() {
        return "hi swagger";
    }

    @GetMapping("/getMethodTwo")
    @ApiOperation(value = "测试接口2", notes = "测试swaggger接口文档")
    @ApiImplicitParam(value = "姓名", name = "name", dataTypeClass = String.class)
    public String getMethodTwo(String name) {
        return "hi swagger:"+name;
    }
}
