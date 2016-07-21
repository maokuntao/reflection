/**
 * �ڼ��һ�������Ϣ֮ǰ��������Ҫ��ȡ���Class����
 */
package com.taomk.study.reflection.ClassObject;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * @author taomk
 *
 */
public class ClassObject {

	public static void main(String[] args) {
		
		long t1 = System.nanoTime();
		Class<MyObject> myObjectClass = MyObject.class;
		long t2 = System.nanoTime();
		
		System.out.println(myObjectClass + " . cost time : " + (t2-t1) + " nano-second.");
		
		String className = "com.taomk.study.reflection.target.MyObject";
		try {
			long t3 = System.nanoTime();
			Class<?> another = Class.forName(className);
			long t4 = System.nanoTime();
			System.out.println(another + " . cost time : " + (t4-t3) + " nano-second.");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found exception.");
			e.printStackTrace();
		}
	}
}
