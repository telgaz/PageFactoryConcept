package tests;

import org.testng.annotations.Test;

public class Invocation {

@Test(invocationCount=2)
public void createUserTest() {
	System.out.println("create user ....");
}
@Test(invocationCount=5)
public void createUser2() {
	System.out.println("create user2 ....");
}
//we define how many times a test will be run 
//by the help of invocationCount


}
