/**
 * 
 */
package com.taomk.study.reflection.ConstructorsInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.taomk.study.reflection.target.MyObject;

/**
 * 返回构造器信息
 * 
 * @author taomk
 *
 */
public class ConstructorsInfo {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;

		System.out.println("__________________构造方法信息（遍历）：_______________________");
		
		// 返回每一个声明为公有的（public）构造方法。
		Constructor<?>[] constructors = myObjectClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor.toGenericString());
		}

		System.out.println("__________________构造方法信息（根据参数返回特定）：_______________________");
		
		Constructor<?> constructorWithParam = null;
		try {
			constructorWithParam = myObjectClass.getConstructor(new Class[] { String.class, String.class });
			System.out.println(constructorWithParam.toGenericString());
		} catch (NoSuchMethodException | SecurityException e) {
			System.err.println("No such method.");
			e.printStackTrace();
		}

		System.out.println("__________________构造方法参数信息：_______________________");
		
		Class<?>[] parameterTypes = constructorWithParam.getParameterTypes();
		for (Class<?> parameterType : parameterTypes) {
			System.out.println(parameterType.getName());
		}
		
		System.out.println("__________________创建一个实例：_______________________");
		
		try {
			MyObject obj = (MyObject) constructorWithParam.newInstance("yonyou" , " 4 test");
			System.out.println(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
