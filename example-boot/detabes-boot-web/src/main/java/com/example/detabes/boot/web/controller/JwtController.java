package com.example.detabes.boot.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.detabes.jwt.util.JwtUtil;
import com.detabes.jwtweb.annotation.ApiMapping;
import com.detabes.jwtweb.util.JwtWebUtil;
import com.detabes.result.result.ResultVO;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author tn
 * @ClassName JwtController
 * @description jwt
 * @date 2020-12-24 09:22
 */
@RestController
@RequestMapping("jwt")
@Api(tags = "jwt测试")
public class JwtController {

    /**
     * 测试jwt拦截
     * @return
     */
    @GetMapping("isJwt")
    @ApiOperation("测试jwt拦截")
    public ResultVO<String> isJwt(){
        return ResultVO.successForData("hi, jwt");
    }

    /**
     * 测试jwt 放行注解
     * @return
     */
    @ApiMapping(value = "isJwts",checkToken = false)
    @ApiOperation("测试jwt 放行注解")
    public ResultVO<String> isJwts(){
        return ResultVO.successForData("hi, jwt, 注解放行");
    }

    /**
     * 获取token - 同时验证放行 配置
     * 接口放行
     * @return
     */
    @ApiOperation("获取token - 同时验证放行 配置")
    @GetMapping("getToken")
    public ResultVO<String> getToken(){
        ImmutableMap<String, String> of = ImmutableMap.of("name", "tan", "age", "25");
        String jsonString = JSONObject.toJSONString(of);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return ResultVO.successForData(JwtUtil.sign("谭宁", jsonObject));
    }

    /**
     * 解析当前token
     * @return
     */
    @ApiOperation("解析当前token")
    @GetMapping("parseNowToke")
    public ResultVO<Map<String, Object>> parseNowToke(HttpServletRequest request){
        String token = JwtWebUtil.getToken(request);
        Map<String, Object> stringObjectMap = JwtUtil.parseJwt(token);
        return ResultVO.successForData(stringObjectMap);
    }

    /**
     * 解析指定token
     * @return
     */
    @GetMapping("parseToke")
    @ApiOperation("解析指定token")
    public ResultVO<Map<String, Object>> parseToke(String token){
//        Map<String, Object> stringObjectMap = JwtUtil.parseJwt(token,"remark");
        String remark = JwtUtil.getClaim(token, "remark");
        return ResultVO.successForData(JSONObject.parseObject(remark));
    }
}
