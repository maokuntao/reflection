/**
 * 
 */
package com.taomk.study.reflection.AnnotationInfo;

import java.lang.annotation.Annotation;

import com.taomk.study.reflection.TargetObject.MyObject;

/**
 * 获取注解信息
 * @author taomk
 *
 */
public class AnnotationInfo {

	public static void main(String[] args) {
		
		Class<MyObject> myObjectClass = MyObject.class;

		Annotation[] annotations = myObjectClass.getAnnotations();
		System.out.println("annotation(s)'s length : " + annotations.length);
		for (int i = 0; i < annotations.length; i++) {
			
			System.out.println(annotations[i].toString());
		}
	}


}
