package com.example.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.sign.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author tn
 * @version 1
 * @ClassName SignParamsSHAController
 * @description
 * @date 2020/12/21 17:13
 */
@RequestMapping("/params/sha")
@RestController
public class SignParamsSHAController {


    /**
     * 验证SHA加密 get 拼接
     * @param name
     * @param age
     * @return
     */
    @GetMapping(value = "/isSignSHA")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHA(String name,String age){
        return ResultVO.successForData(name+age);
    }


    /**
     * 验证SHA加密bean 拼接
     * @param userEntity
     * @return
     */
    @GetMapping(value = "/isSignSHABean")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHABean(UserEntity userEntity){
        return ResultVO.success(JSONObject.toJSONString(userEntity));
    }

    /**
     *  POST验证SHA加密Bean
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignSHABeanP")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHABeanP(UserEntity userEntity){
        return ResultVO.successForData(userEntity);
    }

    /**
     * POST验证SHA加密BeanJson
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignSHABeanPJson")
    @Signature(type = SginEnum.SHA)
    public ResultVO isSignSHABeanPJson(@RequestBody UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.successForData(userEntity);
    }
}
