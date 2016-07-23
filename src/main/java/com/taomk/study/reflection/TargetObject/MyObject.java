package com.taomk.study.reflection.TargetObject;

import java.util.List;

public class MyObject extends MyBase implements MyInterface1 , MyInterface2{
	
	public boolean isBoolean;
	
	private String description;
	
	@SuppressWarnings("unused")
	private List<Object> privateMethod(){
		System.out.println("executecom.taomk.study.reflection.target.MyObject.privateMethod()");
		return null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public MyObject(){
		super();
		System.out.println("Execute com.taomk.study.reflection.target.MyObject.MyObject()...");
	}
	
	public MyObject(String name , String description) {
		super(name);
		this.description = description;
	}

	@Override
	public void method2() {
		System.out.println("execute com.taomk.study.reflection.target.MyObject.method1() ...");
	}

	@Override
	public boolean method1(String flag) {
		System.out.println("execute com.taomk.study.reflection.target.MyObject.method2(String) ...");
		return flag.equals("Y")?true:false;
	}
	
	
	@Override
	public String toString() {
		return "MyObject [isBoolean=" + isBoolean + ", getName()=" + getName() + ",description=" + description + "]";
	}

	public static void main(String[] args) {
		System.out.println(MyObject.class.getClassLoader());
	}
}
