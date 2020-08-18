package tests;

import org.testng.annotations.Test;

public class Enabled {

	
	//enabled==true or false
	
	@Test(priority=1,description="aTest",enabled=true)
	public void aTest() {
		System.out.println("aTest");
	}
	@Test(priority=3,description="bTest",enabled=true)
	public void bTest() {
		System.out.println("bTest");
	}
	@Test(priority=2,description="cTest",enabled=true)
	public void cTest() {
		System.out.println("cTest");
	}
	@Test(priority=4,description="dTest",enabled=false)
	public void dTest() {
		System.out.println("dTest");
	}
	//a,b and c are executed
	//if you  want any test case not to be executed,you need to use 'enabled' key word.
}
