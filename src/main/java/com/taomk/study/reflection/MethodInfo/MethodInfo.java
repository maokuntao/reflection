/**
 * 
 */
package com.taomk.study.reflection.MethodInfo;

import java.lang.reflect.Method;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * ���ط�����Ϣ
 * @author taomk
 *
 */
public class MethodInfo {

	public static void main(String[] args) {
		Class<MyObject> myObjectClass = MyObject.class;

		Method[] method = myObjectClass.getMethods();
		for (int i = 0; i < method.length; i++) {
			
			System.out.println(method[i].toGenericString());
		}

	}

}
