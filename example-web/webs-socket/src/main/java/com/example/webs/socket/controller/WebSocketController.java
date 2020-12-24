package com.example.webs.socket.controller;

import com.detabes.websocket.client.controller.SocketController;
import com.example.webs.socket.service.AlarmWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tn
 * @ClassName WebSocketController
 * @description websocket接口
 * @date 2020-12-24 15:53
 */
@RestController
@RequestMapping("websocket")
public class WebSocketController implements SocketController {

    @Autowired
    private AlarmWebSocketServer alarmWebSocketServer;

    /**
     * 测试接口是否通畅
     * @return
     */
    @RequestMapping("/test01")
    public String testo01(){
        return "websocket";
    }

     /**
     *  使用 sendInfoByLikeKey 进行模糊匹配用户进行消息发送
     *  匹配  keyPrefix 开头的 websocket 用户 给他们发送消息 （keyPrefix用户1, keyPrefix用户2）
     *  @param keyPrefix 主键前缀
     *  @param message 消息
     */
    @RequestMapping("/sendInfoByLikeKey")
    public String sendInfoByLikeKey(String keyPrefix, String message){
        alarmWebSocketServer.sendInfoByLikeKey(keyPrefix, message);
        return "success";
    }

}
