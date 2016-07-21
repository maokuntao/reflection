package com.taomk.study.reflection.ClassName;

import com.taomk.study.reflection.TargetObject.MyObject;

public class ClassName {

	public static void main(String[] args) {
		Class<MyObject> myObjectClass= MyObject.class;
		
		System.out.println(myObjectClass.getName());
		System.out.println(myObjectClass.getSimpleName());
	}
}
