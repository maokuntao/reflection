/**
 * 
 */
package com.taomk.study.reflection.ModifiersInfo;

import java.lang.reflect.Modifier;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * 获取修饰符信息
 * 
 * @author taomk
 *
 */
public class Modifiers {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;

		int modifiers = myObjectClass.getModifiers();

		System.out.println(Modifier.isAbstract(modifiers));
		System.out.println(Modifier.isFinal(modifiers));
		System.out.println(Modifier.isInterface(modifiers));
	}

}
