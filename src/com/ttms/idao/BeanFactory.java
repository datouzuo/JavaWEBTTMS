package com.ttms.idao;



import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import com.ttms.dao.Cuseter_Dao;

public class BeanFactory {

	public static Object getdao(String id) throws ClassNotFoundException, DocumentException, InstantiationException, IllegalAccessException{
	   
	SAXReader reader = new SAXReader();
	String path = BeanFactory.class.getClassLoader().getResource("bean.xml").getPath();
		 Document doc = reader.read(path);
		 Element element = (Element)doc.selectSingleNode("//bean[@id='"+id+"']");
		String aString = element.attributeValue("class");
		Class class1 = Class.forName(aString);
		Object object = class1.newInstance();
		return object;
		
	}
	

	
	
	
}
