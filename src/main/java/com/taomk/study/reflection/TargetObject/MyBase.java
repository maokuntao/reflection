/**
 * 
 */
package com.taomk.study.reflection.TargetObject;

/**
 * 基础父类
 * 
 * @author taomk
 *
 */
public class MyBase {

	private String name;

	public MyBase(){
		System.out.println("Execute com.taomk.study.reflection.target.MyBase.MyBase()...");
	}
	public MyBase(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
