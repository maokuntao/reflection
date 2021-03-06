/**
 * 
 */
package com.taomk.study.reflection.FieldsInfo;

import java.lang.reflect.Field;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * 获取变量信息
 * @author taomk
 *
 */
public class FieldsInfo {

	public static void main(String[] args) {
		
		Class<MyObject> myObjectClass = MyObject.class;

		Field[] fields = myObjectClass.getFields();
		System.out.println("field(s)'s length : " + fields.length);
		for (int i = 0; i < fields.length; i++) {
			
			System.out.println(fields[i].toGenericString());
		}
	}
}
