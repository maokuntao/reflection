/**
 * 
 */
package com.taomk.study.reflection.ConstructorsInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * ���ع�������Ϣ
 * 
 * @author taomk
 *
 */
public class ConstructorsInfo {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;

		System.out.println("__________________���췽����Ϣ������_______________________");
		
		// ����ÿһ������Ϊ���еģ�public�����췽����
		Constructor<?>[] constructors = myObjectClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor.toGenericString());
		}

		System.out.println("__________________���췽����Ϣ����ݲ�����ض�����_______________________");
		
		Constructor<?> constructorWithParam = null;
		try {
			constructorWithParam = myObjectClass.getConstructor(new Class[] { String.class, String.class });
			System.out.println(constructorWithParam.toGenericString());
		} catch (NoSuchMethodException | SecurityException e) {
			System.err.println("No such method.");
			e.printStackTrace();
		}

		System.out.println("__________________���췽��������Ϣ��_______________________");
		
		Class<?>[] parameterTypes = constructorWithParam.getParameterTypes();
		for (Class<?> parameterType : parameterTypes) {
			System.out.println(parameterType.getName());
		}
		
		System.out.println("__________________����һ��ʵ��_______________________");
		
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
