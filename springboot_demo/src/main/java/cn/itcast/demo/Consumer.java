package cn.itcast.demo;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    
    @JmsListener(destination="jettjia")
    public void readMessage(String text) {
        System.out.println("接收到的信息：" + text);
    }
    
    @JmsListener(destination="jettjia_map")
    public void readMap(Map map) {
        System.out.println(map);
    }
}
