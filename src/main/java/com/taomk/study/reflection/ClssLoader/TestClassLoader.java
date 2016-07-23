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

import com.taomk.study.reflection.TargetObject.MyInterface1;

/**
 * 动态加载类
 * 
 * @author taomk
 *
 */
public class TestClassLoader extends ClassLoader {

	private InputStream classFile = null;
	private String name = null;

	/**
	 * TestClassLoader构造时便载入了指定的类文件，因此，就跳过了在new 新的对象时去查找Cache中该类是否有载入的过程。
	 * 
	 * @param name
	 *            String 类全名
	 * @param url
	 *            URL 类路径
	 * @throws IOException
	 */
	public TestClassLoader(String name, URL url) throws IOException {

		super(getSystemClassLoader());

		this.name = name + ".class";

		// 打开URL指定的资源
		URLConnection connect = url.openConnection();
		InputStream classIs = connect.getInputStream();
		this.classFile = classIs;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte buf[] = new byte[1024];
		// 读取文件流
		for (int i = 0; i != -1; i = classIs.read(buf)) {
			baos.write(buf, 0, i);
		}
		classIs.close();
		baos.close();

		// 创建新的类对象
		byte[] data = baos.toByteArray();
		defineClass(name, data, 0, data.length);
	}

	/**
	 * 重载getResourcesAsStream(String)以返回类的文件流
	 * 
	 * @param resourcesName
	 * @return an InputStream of the Class Bytes , or null
	 */
	public InputStream getResourcesAsStream(String resourcesName) {
		try {
			if (resourcesName.equals(name)) {
				return this.classFile;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public static void main(String[] args) {
		String name = "com.taomk.study.reflection.TargetObject.MyObject";
		try {
			URL url = new URL(
					"file:/Users/Dev/github/reflection/target/classes/com/taomk/study/reflection/TargetObject/MyObject.class");
			ClassLoader loader = new TestClassLoader(name, url);
			Class<?> c = Class.forName(name, false, loader);
			MyInterface1 interface1 = (MyInterface1) c.newInstance();
			System.out.println(interface1.method1("Y"));
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
