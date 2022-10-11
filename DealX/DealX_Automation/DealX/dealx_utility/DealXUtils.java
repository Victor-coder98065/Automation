package dealx_utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import dealx_accelerators.DealXBase;
import dealx_utility.DealXExceptionHandle;

public class DealXUtils extends DealXBase {

	public static String FILE_NAME = System.getProperty("user.dir")+"//DealXData//config.properties";
	public static Properties properties=null;
	
	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}
	static {
		File f = new File(FILE_NAME);
		properties = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			properties.load(in);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			e.printStackTrace();
		}

	}
	public static String getProperty(String strKey) {
		String strValue = null;
		try{
			File f = new File(FILE_NAME);
			if(f.exists()){
				strValue=properties.getProperty(strKey);
			}
			else
				DealXExceptionHandle.HandleAssertion("File not found");
		}
		catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
		}
		return strValue;
	}
}
