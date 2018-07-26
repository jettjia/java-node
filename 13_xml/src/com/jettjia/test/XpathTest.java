package com.jettjia.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {

	public static void main(String[] args) {
		try {
			// 1.创建SaxReader对象
			SAXReader saxReader = new SAXReader();
			// 2.指定解析的xml
			Document read = saxReader.read(new File("src/xml/stus.xml"));
			// 3. 获取根元素
			Element rootElement = read.getRootElement();
			// 4.获取某个元素的集合，比如name
			List<Element> selectNodes = rootElement.selectNodes("//name");
			for (Element element : selectNodes) {
				String name = element.getText();
				System.out.println(name);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
