/**
 * 
 */
package com.taomk.study.reflection.ClssLoader;

import java.net.URL;

/**
 * Java动态加载类
 * 
 * @author taomk
 *
 */
public class ClssLoaderInfo {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {

		// bootstrap classloader 引导类（原始类）加载器，负责加载Java的核心类，它并不是一个真正的classloader
		// 在执行java的命令中使用-Xbootclasspath选项或者使用-D选项指定sun.boot.class.path系统属性值可以指定附件的类。
		// JVM启动时自动加载的核心类库
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
		}

		System.out.println();

		// extension classloader 扩展类加载器，负责加载JRE的扩展目录中JAR包
		System.out.println(System.getProperty("java.ext.dirs"));
		ClassLoader extensionClassLoader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("The parent of extension classloader : " + extensionClassLoader);

		System.out.println();

		// system classloader
		// 系统（应用）类加载器，负责在负责在JVM启动时，加载来自命令java中的-classpath或者java.class.path系统属性所指定的JAR包和类路径
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println();
		
		System.out.println(System.class.getClassLoader());
	}
}
