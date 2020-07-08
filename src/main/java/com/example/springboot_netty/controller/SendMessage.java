package com.example.springboot_netty.controller;


import com.example.springboot_netty.pojo.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class SendMessage{

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
     */
    public void sendMessage() {
        messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));
    }

    /**
     * 发送信息给指定用户
     */
    public void sendMessageToUser(){
        System.out.println("来自服务端的消息,推送给指定用户");
        messagingTemplate.convertAndSendToUser("1","/server/sendMessageByServer",System.currentTimeMillis());
    }

}