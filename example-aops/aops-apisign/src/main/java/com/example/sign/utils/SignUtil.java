package com.example.sign.utils;

import com.alibaba.fastjson.JSONObject;
import com.detabes.encryption.constant.SignConstant;
import com.detabes.encryption.core.SignMD5Util;
import com.example.sign.entity.UserEntity;

import java.util.LinkedHashMap;

/**
 * @author tn
 * @version 1
 * @ClassName SignUtil
 * @description 验证工具
 * @date 2020/12/22 10:03
 */
public class SignUtil extends com.detabes.apisign.util.SignUtil {


    public static String getSignByJson(UserEntity userEntity){
        String encrypt1 = SignMD5Util.encrypt(JSONObject.toJSONString(userEntity),true);
        return SignMD5Util.encrypt(encrypt1+ SignConstant.MD5_PRIVATE_KEY, true);
    }

    public static String getSignByBean2LinkedHashMap2Str(UserEntity userEntity){
        LinkedHashMap<String, Object> stringObjectLinkedHashMap = TempUtil.beanToLinkedHashMap(userEntity);
        String encrypt1 = SignMD5Util.encrypt(map2Str(stringObjectLinkedHashMap),true);
        return SignMD5Util.encrypt(encrypt1+ SignConstant.MD5_PRIVATE_KEY, true);
    }

}
