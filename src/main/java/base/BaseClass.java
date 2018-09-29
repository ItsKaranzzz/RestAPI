package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

	public static Properties oProp;
	
	public static int repsonseCode_200=200;
	public static int repsonseCode_201=201;
	public static int repsonseCode_400=400;
	public static int repsonseCode_404=404;
	public static int repsonseCode_405=405;
	public static int repsonseCode_202=202;
	public static int repsonseCode_500=500;
	

	public static void initialize() {

		oProp = new Properties();
		try {
			oProp.load(new FileInputStream(
					new File("E:\\Program Files\\MyWorkspace\\RestAPI\\src\\main\\java\\config\\config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
