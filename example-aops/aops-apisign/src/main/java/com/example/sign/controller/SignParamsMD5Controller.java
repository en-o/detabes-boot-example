package com.example.sign.controller;

import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.sign.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

/**
 * MD5 sign 跟在 参数中
 *    @Signature(type = SginEnum.MD5)
 * @author tn
 * @version 1
 * @ClassName SignController
 * @description 验证签名
 * @date 2020/11/25 12:59
 */
@RequestMapping("/params/md5")
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
        return ResultVO.successForData(name+age);
    }

    /**
     * 验证MD5加密 - get 拼接
     * @param name
     * @param age
     * @return
     */
    @GetMapping(value = "/isSignMD5")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5(String name,String age){
        return ResultVO.successForData(name+age);
    }


    /**
     * 验证MD5加密 - get bean 拼接
     * @param UserEntity
     * @return
     */
    @GetMapping(value = "/isSignMD5Bean")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5Bean(UserEntity UserEntity){
        return ResultVO.successForData(UserEntity);
    }

    /**
     * 验证MD5加密 - post bean
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignMD5BeanP")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5BeanP(UserEntity userEntity){
        return ResultVO.successForData(userEntity);
    }

    /**
     * 验证MD5加密 - post json
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignMD5BeanPJson")
    @Signature(type = SginEnum.MD5)
    public ResultVO isSignMD5BeanPJson(@RequestBody(required = false) UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.successForData(userEntity);
    }

}
