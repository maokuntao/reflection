/**
 * 
 */
package com.taomk.study.reflection.InterfacesInfo;

import com.taomk.study.reflection.target.MyObject;

/**
 * 返回接口信息
 * @author taomk
 *
 */
public class InterfacesInfo {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;
		// 返回接口数组
		Class<?>[] interfaces = myObjectClass.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			
			System.out.println(interfaces[i].getName());
		}
	}

}
