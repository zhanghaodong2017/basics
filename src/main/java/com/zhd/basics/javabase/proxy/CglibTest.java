package com.zhd.basics.javabase.proxy;

import net.sf.cglib.core.DebuggingClassWriter;

public class CglibTest {

	public static void main(String[] args) {
		// 将cglib生成的class写入到E:\\classes文件夹中
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\classes");
		MyInterceptor interceptor = new MyInterceptor();
		CglibTest cglibTest = (CglibTest) interceptor.getProxy(CglibTest.class);
		cglibTest.operate1("zhangsan");
	}

	public String operate1(String name) {
		System.out.println("操作数据库1");
		return name;
	}

}
