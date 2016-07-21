/**
 * 
 */
package com.taomk.study.reflection.ClssLoader;

import java.net.URL;

/**
 * Java类加载逻辑
 * 
 * @author taomk
 *
 */
public class ClssLoaderInfo {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {

		/**
		 * bootstrap classloader － 引导（也称为原始）类加载器。
		 * 它负责加载Java的核心类。
		 * 在Sun的JVM中，在执行java的命令中使用-Xbootclasspath选项或使用-D选项指定sun.boot.class.path系统属性值可以指定附加的类。
		 * 这个加载器的是非常特殊的，它实际上不是java.lang.ClassLoader的子类，而是由JVM自身实现的。
		 * 
		 */
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
		}

		System.out.println();

		/**
		 * 
		 * extension classloader － 扩展类加载器。
		 * 它负责加载JRE的扩展目录（JAVA_HOME/jre/lib/ext或者由java.ext.dirs系统属性指定的）中JAR的类包。
		 * 这为引入除Java核心类以外的新功能提供了一个标准机制。
		 * 因为默认的扩展目录对所有从同一个JRE中启动的JVM都是通用的，所以放入这个目录的JAR类包对所有的JVM和system classloader都是可见的。
		 * 在这个实例上调用方法getParent()总是返回空值null，因为引导加载器bootstrap classloader不是一个真正的ClassLoader实例。
		 */
		System.out.println(System.getProperty("java.ext.dirs"));
		ClassLoader extensionClassLoader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("The parent of extension classloader : " + extensionClassLoader);

		System.out.println();

		/**
		 *system classloader － 系统（也称为应用）类加载器。
		 *它负责在JVM被启动时，加载来自在命令java中的-classpath或者java.class.path系统属性或者CLASSPATH操作系统属性所指定的JAR类包和类路径。
		 *总能通过静态方法ClassLoader.getSystemClassLoader()找到该类加载器。
		 *如果没有特别指定，则用户自定义的任何类加载器都将该类加载器作为它的父加载器。 
		 */
		System.out.println(System.getProperty("java.class.path"));

		System.out.println();

		System.out.println(System.class.getClassLoader());
	}
}
