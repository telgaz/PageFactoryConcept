package tests;

import org.testng.annotations.Test;

public class DependsOnMethod {

@Test(priority=1)
public void loginTest() {
	System.out.println("login test");
}
@Test(priority=2,dependsOnMethods="loginTest")
public void homePageTest() {
	System.out.println("home page test");
}
@Test(priority=3,dependsOnMethods="homePageTest")
public void searchPageTest() {
	System.out.println("search page test");
}
}
