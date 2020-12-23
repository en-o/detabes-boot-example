package com.example.redis.pub.message;

import com.detabes.redis.pub.server.RedisReceiverServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

/**
 * @ClassName : MessageSave
 * @Description : redis订阅消息保存起来
 * @Author : tn
 * @Date: 2020-09-11 10:54
 */
@Service
@Slf4j
public class RedisReceiverImpl implements RedisReceiverServer<String> {
    @Override
    public String pubMessage(Message message) {
        log.info("自定义保存方法："+message.toString());
        return null;
    }
}