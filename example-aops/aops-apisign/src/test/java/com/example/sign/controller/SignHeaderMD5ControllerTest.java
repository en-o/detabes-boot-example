package com.example.sign.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.detabes.encryption.core.SignMD5Util;
import com.example.sign.entity.UserEntity;
import com.example.sign.entity.UserEntity2;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *  @Signature(type = SginEnum.MD5HEADER)
 */
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class SignHeaderMD5ControllerTest {

    /**
     * 模拟mvc测试对象
     */
    @Autowired
    private MockMvc mockMvc;


    public static String PRIVATE_KEY = "MD5database";


    /**
     * 验证MD5加密 - post json header
     *
     * @throws Exception
     */
    @Test
    void testIsSignMD5BeanPJsonH() throws Exception {
        UserEntity user = UserEntity.builder().age("123").name("谭宁").build();
        // 获取加密串
        String sign = sign(user);
        // 正确
        HttpHeaders heanders = new HttpHeaders();
        heanders.set("sign",sign);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/header/isSignMD5BeanPJsonH")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .headers(heanders)
                .content(JSONObject.toJSONString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andReturn();

    }

    /**
     * 验证MD5加密 - get bean 拼接 header
     */
    @Test
    void testIsSignMD5BeanH() throws Exception {
        UserEntity user = UserEntity.builder().age("123").name("谭宁").build();
        String userParams = String.format("age=%s&name=%s",user.getAge(), user.getName());
        // 获取加密串
        String sign = sign(user);
        // 正确
        HttpHeaders heanders = new HttpHeaders();
        heanders.set("sign",sign);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/header/isSignMD5BeanH?"+userParams)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .headers(heanders))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andReturn();

    }


    /**
     * 验证MD5加密 - post list header
     */
    @Test
    void testIsSignMD5ListBeanPH() throws Exception {

        ArrayList<UserEntity> userArrayList = new ArrayList<>();
        UserEntity user = UserEntity.builder().age("123").name("谭宁").build();
        userArrayList.add(user);
        user = UserEntity.builder().age("456").name("谭宁2").build();
        userArrayList.add(user);
        user = UserEntity.builder().age("789").name("谭宁3").build();
        userArrayList.add(user);
        // 获取加密串
        String jsonString = JSONArray.toJSONString(userArrayList);
        String sign = sign(jsonString);
        // 正确
        HttpHeaders heanders = new HttpHeaders();
        heanders.set("sign",sign);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/header/isSignMD5ListBeanPH")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .headers(heanders)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is(true)))
                .andReturn();
    }



/**********************************   私有方法  *************************************************/
    private String sign(UserEntity userEntity){
        String encrypt1 = SignMD5Util.encrypt(JSONObject.toJSONString(userEntity),true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }

    private String sign(Map userEntity){
        String encrypt1 = SignMD5Util.encrypt(JSONObject.toJSONString(userEntity),true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }

    /**
     * 注意顺序就是 age，name
     * @param age
     * @param name
     * @return
     */
    private String sign(String age,String name){
        String userParams = String.format("age=%s&name=%s",age, name);
        String encrypt1 = SignMD5Util.encrypt(userParams,true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }
    /**
     * @return
     */
    private String sign(String jsonStr){
        String encrypt1 = SignMD5Util.encrypt(jsonStr,true);
        return SignMD5Util.encrypt(encrypt1+PRIVATE_KEY, true);
    }
}