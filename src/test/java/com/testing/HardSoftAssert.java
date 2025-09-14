package com.testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardSoftAssert {
	
	@Test
	private void hardAssert() {
		String name = "Dharsan";
		String nam = "dharsan";
		if (name==nam) {
			Assert.assertEquals(name, nam);
			System.out.println("VALIDATION DONE");
		}
		else{
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(name, nam);
			System.out.println("VERIFICATION DONE");

		}
	}
	
//		@Test
//		private void softAssert() {
//			String act = "Dharsan";
//			String exp = "dharsan";
//			
//			
//			
//		}

}
