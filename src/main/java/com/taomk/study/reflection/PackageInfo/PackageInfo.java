/**
 * 
 */
package com.taomk.study.reflection.PackageInfo;

import com.taomk.study.reflection.target.MyObject;

/**
 * °üÐÅÏ¢
 * @author taomk
 *
 */
public class PackageInfo {

	public static void main(String[] args) {
		Class<MyObject> myObjectClass = MyObject.class;

		System.out.println(myObjectClass.getPackage());
	}

}
