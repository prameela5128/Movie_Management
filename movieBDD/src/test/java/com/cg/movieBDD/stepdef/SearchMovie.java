package com.cg.movieBDD.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchMovie {
	WebDriver driver;


	@Given("^User is on search page$")
	public void user_is_on_search_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\Desktop Dumps\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/searchMovie");
		driver.manage().window().maximize();
	}

	@When("^User enter valid movie name$")
	public void user_enter_valid_movie_name() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys("Telugu");
	   // driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		 driver.findElement(By.xpath("/html/body/app-root/div/app-search-movie/div/div/form/table/tr[3]/td/button")).click();
	}

	@Then("^User get the movie details$")
	public void user_get_the_movie_details() throws Throwable {
		System.out.println("Movie details exist");
	}

	@When("^User enter invalid movie name$")
	public void user_enter_invalid_movie_name() throws Throwable {
		System.out.println("Inside invalid credentials");
		driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys("AAA");
//	    driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("/html/body/app-root/div/app-search-movie/div/div/form/table/tr[3]/td/button")).click();
	}

	@Then("^User get the message Movie with Name Not Found\\.$")
	public void user_get_the_message_Movie_with_Name_Not_Found() throws Throwable {
		 String errorMsg="Movie with Name AAA not found";
		   String actualMsg=driver.findElement(By.xpath("//p[contains(text(),'Movie with Name AAA not found')]")).getText();
		   Assert.assertEquals(actualMsg,errorMsg);
		   System.out.println("Movie with Name AAA not found");

	}


}
