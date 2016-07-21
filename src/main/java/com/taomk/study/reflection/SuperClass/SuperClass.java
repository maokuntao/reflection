/**
 * 
 */
package com.taomk.study.reflection.SuperClass;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * ���ظ�����Ϣ
 * @author taomk
 *
 */
public class SuperClass {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;
		System.out.println(myObjectClass.getSuperclass());
	}

}
