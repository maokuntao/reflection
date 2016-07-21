/**
 * 
 */
package com.taomk.study.reflection.InterfacesInfo;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * ���ؽӿ���Ϣ
 * @author taomk
 *
 */
public class InterfacesInfo {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;
		// ���ؽӿ�����
		Class<?>[] interfaces = myObjectClass.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			
			System.out.println(interfaces[i].getName());
		}
	}

}
