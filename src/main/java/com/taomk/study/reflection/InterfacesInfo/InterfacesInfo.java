/**
 * 
 */
package com.taomk.study.reflection.InterfacesInfo;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * 获取实现的接口信息
 * @author taomk
 *
 */
public class InterfacesInfo {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;
		Class<?>[] interfaces = myObjectClass.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			
			System.out.println(interfaces[i].getName());
		}
	}

}
