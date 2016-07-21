/**
 * 
 */
package com.taomk.study.reflection.ModifiersInfo;

import java.lang.reflect.Modifier;

import com.taomk.study.reflection.target.MyObject;

/**
 * 修饰符
 * 
 * @author taomk
 *
 */
public class Modifiers {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;

		// 返回类的修饰符，即public、private、static等关键字
		int modifiers = myObjectClass.getModifiers();

		// 修饰符被包装成一个int类型的数字，这样每个修饰符都是一个位标识（flag
		// bit），这个标识可以设置和清除修饰符的类型。可以使用java.lang.reflect.Modifer类中的方法来检查修饰符的类型：
		
		System.out.println(Modifier.isAbstract(modifiers));
		System.out.println(Modifier.isFinal(modifiers));
		System.out.println(Modifier.isInterface(modifiers));
	}

}
