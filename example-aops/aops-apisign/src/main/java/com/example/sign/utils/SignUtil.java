package com.example.sign.utils;

import com.alibaba.fastjson.JSONObject;
import com.detabes.encryption.core.SignMD5Util;
import com.example.sign.entity.UserEntity;

import java.util.Map;

/**
 * @author tn
 * @version 1
 * @ClassName SignUtil
 * @description 验证工具
 * @date 2020/12/22 10:03
 */
public class SignUtil {

    public static String PRIVATE_KEY = "MD5database";

    public static String sign(UserEntity userEntity){
        String encrypt1 = SignMD5Util.encrypt(JSONObject.toJSONString(userEntity),true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }

    public static String sign(Map userEntity){
        String encrypt1 = SignMD5Util.encrypt(JSONObject.toJSONString(userEntity),true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }

    /**
     * 注意顺序就是 age，name
     * @param age
     * @param name
     * @return
     */
    public static String sign(String age,String name){
        String userParams = String.format("age=%s&name=%s",age, name);
        String encrypt1 = SignMD5Util.encrypt(userParams,true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }
    /**
     * @return
     */
    public static String sign(String jsonStr){
        String encrypt1 = SignMD5Util.encrypt(jsonStr,true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }
}
