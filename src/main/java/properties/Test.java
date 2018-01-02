package properties;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
/**
 * 读取properties文件
 * @author wsz
 * @date 2018年1月2日
 */
public class Test {

	public static void main(String[] args) {
		readProperties1();
		readProperties2();
	}
	
	/**
	 * 需要文件与该类在同一目录下，否则无法找到文件
	 */
	private static void readProperties2() {
		try {
			InputStream is = Test.class.getResourceAsStream("params.properties"); 
			Properties prop = new Properties();
			prop.load(is);
			String year  = prop.getProperty("com.year");
			String month = prop.getProperty("com.month");
			String day   = prop.getProperty("com.day");
			System.out.println(year+"-"+month+"-"+day);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Resourcebundle读取文件
	 */
	private static void readProperties1() {
		ResourceBundle bundle = ResourceBundle.getBundle("params");
		String year = bundle.getString("com.year");
		String month =  bundle.getString("com.month");
		String day = bundle.getString("com.day");
		System.out.println(year+"-"+month+"-"+day);
		//遍历时是乱序的
		Enumeration<String> keys = bundle.getKeys();
		for (Enumeration<String> e = keys; e.hasMoreElements() ; ) {
			String key   = e.nextElement();
			String value = bundle.getString(key);
			System.out.println(key+"-"+value);
		}
	}
}
