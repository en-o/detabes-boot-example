package com.example.detabes.boot.web.controller;

import com.detabes.annotation.mapping.PathRestController;
import com.detabes.apisign.annotation.Signature;
import com.detabes.apisign.enums.SginEnum;
import com.detabes.result.result.ResultVO;
import com.example.detabes.boot.web.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
@PathRestController("/header/md5")
@Api(tags = "验证签名")
public class SignHeaderMD5Controller {


    /**
     * 验证MD5加密 - post json header
     * @param userEntity
     * @return
     */
    @PostMapping(value = "/isSignMD5BeanPJsonH")
    @Signature(type = SginEnum.MD5HEADER)
    @ApiOperation("验证MD5加密 - post json header")
    public ResultVO isSignMD5BeanPJsonH(@RequestBody UserEntity userEntity){
        System.out.println("userEntity.toString() = " + userEntity.toString());
        return ResultVO.successForData(userEntity);
    }

    /**
     * 验证MD5加密 - get bean 拼接 header
     * @param userEntity
     * @return
     */
    @GetMapping(value = "/isSignMD5BeanH")
    @ApiOperation("验证MD5加密 - get bean 拼接 header")
    @Signature(type = SginEnum.MD5HEADER)
    public ResultVO isSignMD5BeanH(UserEntity userEntity){
        return ResultVO.successForData(userEntity);
    }

    /**
     * 验证MD5加密 - post list header
     * @param list
     * @return
     */
    @PostMapping(value = "/isSignMD5ListBeanPH")
    @Signature(type = SginEnum.MD5HEADER)
    @ApiOperation("验证MD5加密 - post list header")
    public ResultVO isSignMD5ListBeanPH(@RequestBody List<UserEntity> list){
        return ResultVO.successForData(list);
    }


}
