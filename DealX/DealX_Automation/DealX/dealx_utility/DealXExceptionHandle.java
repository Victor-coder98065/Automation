package dealx_utility;

import static org.junit.Assert.fail;

import org.junit.Assert;

import dealx_accelerators.DealXActions;

public class DealXExceptionHandle {

	// Function to handle exceptions
			public static void HandleException(Exception e, String sError) {
				try {
					System.out.println(sError);
				} catch (Exception ex) {
					System.out.println(ex.getStackTrace().toString());
					Assert.fail(sError);
				}
			}
			public static void HandleAssertion(String sError) {
				try {
				} catch (Exception e) {
					System.out.println(e.getStackTrace().toString());
					Assert.fail(sError);
				}
			}
			public static void HandleScreenShotException (Exception e, String sError) {
				try {
					 System.out.println(sError);
					 System.out.println(e.getStackTrace());
					 Assert.fail(sError);
				} catch (Exception ex) {
					System.out.println(ex.getStackTrace().toString());
					Assert.fail(sError);
				} 
			}
}
