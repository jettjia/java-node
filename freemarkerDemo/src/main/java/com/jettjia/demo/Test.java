package com.jettjia.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Test {
    public static void main(String[] args) throws IOException, TemplateException {
        // 1.创建配置类型
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 2.设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("D:/develop/java_study/freemarkerDemo/src/main/resources/"));
        // 3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        // 4.加载模板
        Template template = configuration.getTemplate("test.ftl");
        // 5.创建数据模型
        Map map = new HashMap();
        map.put("name", "jett");
        map.put("message", "hello freemarker");
        map.put("success", true);
        
        // 赋值商品列表测试
        List arrayList = new ArrayList();
        Map goods1 = new HashMap();
        goods1.put("name", "apple");
        goods1.put("price", 5.8);
        Map goods2 = new HashMap();
        goods2.put("name", "banana");
        goods2.put("price", 2.0);
        arrayList.add(goods1);
        arrayList.add(goods2);
        
        map.put("goodsList", arrayList);
        
        map.put("today", new Date());
        map.put("point", 102845721);
        // 6. 创建writer对象
        Writer out = new FileWriter(new File("d:\\test.html"));
        // 7.输出
        template.process(map, out);
        // 8.关闭writer对象
        out.close();
    }
}
