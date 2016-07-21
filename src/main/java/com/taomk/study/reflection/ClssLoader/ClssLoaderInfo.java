/**
 * 
 */
package com.taomk.study.reflection.ClssLoader;

import java.net.URL;

/**
 * Java��̬������
 * 
 * @author taomk
 *
 */
public class ClssLoaderInfo {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {

		// bootstrap classloader �����ࣨԭʼ�ࣩ���������������Java�ĺ����࣬��������һ��������classloader
		// ��ִ��java��������ʹ��-Xbootclasspathѡ�����ʹ��-Dѡ��ָ��sun.boot.class.pathϵͳ����ֵ����ָ���������ࡣ
		// JVM����ʱ�Զ����صĺ������
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
		}

		System.out.println();

		// extension classloader ��չ����������������JRE����չĿ¼��JAR��
		System.out.println(System.getProperty("java.ext.dirs"));
		ClassLoader extensionClassLoader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println("The parent of extension classloader : " + extensionClassLoader);

		System.out.println();

		// system classloader
		// ϵͳ��Ӧ�ã���������������ڸ�����JVM����ʱ��������������java�е�-classpath����java.class.pathϵͳ������ָ����JAR������·��
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println();
		
		System.out.println(System.class.getClassLoader());
	}
}
