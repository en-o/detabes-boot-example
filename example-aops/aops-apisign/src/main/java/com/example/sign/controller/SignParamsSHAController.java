package com.example.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.sign.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author tn
 * @version 1
 * @ClassName SignParamsSHAController
 * @description
 * @date 2020/12/21 17:13
 */
public class SignParamsSHAController {


    @GetMapping(value = "/isSignSHA")
    @ApiOperation(value = "验证SHA加密")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA1(String name,String age){
        return ResultVO.success(name+age);
    }


    @GetMapping(value = "/isSignSHAMap")
    @ApiOperation(value = "验证SHA加密Map")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA1Map(@RequestParam Map<String,Object> map){
        return ResultVO.success(JSONObject.toJSONString(map));
    }


    @GetMapping(value = "/isSignSHABean")
    @ApiOperation(value = "验证SHA加密Bean")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA1Bean(UserEntity userEntity){
        return ResultVO.success(userEntity);
    }



    @PostMapping(value = "/isSignSHABeanP")
    @ApiOperation(value = "POST验证SHA加密Bean")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA1BeanP(UserEntity userEntity){
        return ResultVO.success(userEntity);
    }




    @PostMapping(value = "/isSignSHABeanPJson")
    @ApiOperation(value = "POST验证SHA加密BeanJson")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA1BeanPJson(@RequestBody UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.success(userEntity);
    }
}
