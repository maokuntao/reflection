/**
 * 
 */
package com.taomk.study.reflection.ModifiersInfo;

import java.lang.reflect.Modifier;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * ���η�
 * 
 * @author taomk
 *
 */
public class Modifiers {

	public static void main(String[] args) {

		Class<MyObject> myObjectClass = MyObject.class;

		// ����������η�public��private��static�ȹؼ���
		int modifiers = myObjectClass.getModifiers();

		// ���η��װ��һ��int���͵����֣�����ÿ�����η���һ��λ��ʶ��flag
		// bit���������ʶ�������ú�������η�����͡�����ʹ��java.lang.reflect.Modifer���еķ�����������η�����ͣ�
		
		System.out.println(Modifier.isAbstract(modifiers));
		System.out.println(Modifier.isFinal(modifiers));
		System.out.println(Modifier.isInterface(modifiers));
	}

}
