package cn.itcast.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息生产者
 * @author ThinkPad
 *
 */
@RestController
public class QueueController {
    
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    
    @RequestMapping("/send")
    private void send(String text) {
        jmsMessagingTemplate.convertAndSend("jettjia", text);;
    }
    
    @RequestMapping("/sendmap")
    public void sendMap() {
        Map map = new HashMap();
        map.put("mobile", "15026635821");
        map.put("content", "恭喜获得10元代金券");
        jmsMessagingTemplate.convertAndSend("jettjia_map", map);
    }
    
    @RequestMapping("/sendsms")
    public void sendSms() {
        Map map = new HashMap();
        map.put("mobile", "15026635821");
        map.put("template_code", "SMS_143718390");
        map.put("sign_name", "jett技术之家");
        map.put("param", "{\"code\":\"123456\"}");
        jmsMessagingTemplate.convertAndSend("sms", map);
    }
}
