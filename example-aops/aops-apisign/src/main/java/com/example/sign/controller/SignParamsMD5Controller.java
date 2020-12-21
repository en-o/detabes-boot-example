package com.example.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.sign.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * MD5 sign 跟在 参数中
 *    @Signature(type = SginEnum.MD5)
 * @author tn
 * @version 1
 * @ClassName SignController
 * @description 验证签名
 * @date 2020/11/25 12:59
 */
@RequestMapping("/params")
@RestController
public class SignParamsMD5Controller {


    /**
     * 接口不签名
     * @param name
     * @param age
     * @return
     */
    @GetMapping(value = "/isSign")
    @Signature(type = SginEnum.ANY)
    public ResultVO isSign(String name, String age){
        return ResultVO.success(name+age);
    }

    @GetMapping(value = "/isSignMD5")
    @ApiOperation(value = "验证MD5加密 - get 拼接")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5(String name,String age){
        return ResultVO.success(name+age);
    }



    @GetMapping(value = "/isSignMD5Map")
    @ApiOperation(value = "验证MD5加密 - get map 拼接")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5Map(@RequestParam Map<String,Object> map){
        return ResultVO.success(JSONObject.toJSONString(map));
    }


    @GetMapping(value = "/isSignMD5Bean")
    @ApiOperation(value = "验证MD5加密 - get bean 拼接 ")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5Bean(UserEntity UserEntity){
        return ResultVO.success(UserEntity);
    }


    @PostMapping(value = "/isSignMD5BeanP")
    @ApiOperation(value = "验证MD5加密 - post bean ")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5BeanP(UserEntity userEntity){
        return ResultVO.success(userEntity);
    }


    @PostMapping(value = "/isSignMD5BeanPJson")
    @ApiOperation(value = "验证MD5加密 - post json ")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5BeanPJson(@RequestBody(required = false) UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.success(userEntity);
    }

}
