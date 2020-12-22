package com.example.sign.controller;

import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.sign.entity.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * MD5 sign 跟在 header中
 *   @Signature(type = SginEnum.MD5HEADER)
 * @author tn
 * @version 1
 * @ClassName SignHeaderController
 * @description 验证签名
 * @date 2020/12/21 14:39
 */
@RequestMapping("/header/md5")
@RestController
public class SignHeaderMD5Controller {


    /**
     * 验证MD5加密 - post json header
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignMD5BeanPJsonH")
    @Signature(type = SginEnum.MD5HEADER)
    public ResultVO isSignMD5BeanPJsonH(@RequestBody UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.success(userEntity);
    }

    /**
     * 验证MD5加密 - get bean 拼接 header
     * @param userEntity
     * @return
     */
    @GetMapping(value = "/isSignMD5BeanH")
    @ApiOperation(value = " ")
    @Signature(type = SginEnum.MD5HEADER)
    public ResultVO isSignMD5BeanH(UserEntity userEntity){
        return ResultVO.success(userEntity);
    }

    /**
     * 验证MD5加密 - post list header
     * @param list
     * @return
     */
    @PostMapping(value = "/isSignMD5ListBeanPH")
    @Signature(type = SginEnum.MD5HEADER)
    public ResultVO isSignMD5ListBeanPH(@RequestBody List<UserEntity> list){
        return ResultVO.success(list);
    }


}
