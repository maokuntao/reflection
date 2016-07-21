/**
 * 
 */
package com.taomk.study.reflection.SuperClass;

import com.taomk.study.reflection.target.MyObject;

/**
 * 返回父类信息
 * @author taomk
 *
 */
public class SuperClass {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;
		System.out.println(myObjectClass.getSuperclass());
	}

}
