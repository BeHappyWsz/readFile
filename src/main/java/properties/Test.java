package properties;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
/**
 * ��ȡproperties�ļ�
 * @author wsz
 * @date 2018��1��2��
 */
public class Test {

	public static void main(String[] args) {
		readProperties1();
		readProperties2();
	}
	
	/**
	 * ��Ҫ�ļ��������ͬһĿ¼�£������޷��ҵ��ļ�
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
	 * ʹ��Resourcebundle��ȡ�ļ�
	 */
	private static void readProperties1() {
		ResourceBundle bundle = ResourceBundle.getBundle("params");
		String year = bundle.getString("com.year");
		String month =  bundle.getString("com.month");
		String day = bundle.getString("com.day");
		System.out.println(year+"-"+month+"-"+day);
		//����ʱ�������
		Enumeration<String> keys = bundle.getKeys();
		for (Enumeration<String> e = keys; e.hasMoreElements() ; ) {
			String key   = e.nextElement();
			String value = bundle.getString(key);
			System.out.println(key+"-"+value);
		}
	}
}
