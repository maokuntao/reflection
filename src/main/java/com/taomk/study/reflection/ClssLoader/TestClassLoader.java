/**
 * 
 */
package com.taomk.study.reflection.ClssLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.taomk.study.reflection.target.MyInterface1;

/**
 * 自己实现类的动态载入
 * @author taomk
 *
 */
public class TestClassLoader extends ClassLoader{

	private InputStream classFile = null;
	private String name = null;
	
	/**
	 * @param name String 类全名
	 * @param url URL 类路径
	 * @throws IOException 
	 */
	public TestClassLoader(String name, URL url) throws IOException{
		
		super(getSystemClassLoader());
		
		this.name = name + ".class";
		
		URLConnection connect = url.openConnection();
		InputStream classIs = connect.getInputStream();
		this.classFile = classIs;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte buf[] = new byte[1024];
		for (int i = 0; i!=-1; i=classIs.read(buf)) {
			baos.write(buf , 0 , i);
		}
		classIs.close();
		baos.close();
		
		byte[] data = baos.toByteArray();
		defineClass(name , data , 0 , data.length);
	}
	
	/**
	 * 返回该类的文件流
	 * @param resourcesName 
	 * @return an InputStream of the Class Bytes , or null
	 */
	public InputStream getResourcesAsStream(String resourcesName){
		try {
			if(resourcesName.equals(name)){
				return this.classFile;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public static void main(String[] args) {
		String name = "com.taomk.study.reflection.target.MyObject";
		try {
			URL url = new URL("file:/E:/workspace_study/reflection/target/classes/com/taomk/study/reflection/target/MyObject.class");
			ClassLoader loader = new TestClassLoader(name, url);
			Class<?> c = Class.forName(name , false , loader);
			MyInterface1 interface1 = (MyInterface1)c.newInstance();
			System.out.println(interface1.method2("Y"));
		} catch (MalformedURLException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.println(e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
}
