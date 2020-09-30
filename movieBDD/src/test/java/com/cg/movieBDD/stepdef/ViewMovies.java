package com.cg.movieBDD.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewMovies {
	WebDriver driver;

	@Given("^User is on home page$")
	public void user_is_on_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\Desktop Dumps\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^User enter clicks the search button$")
	public void user_enter_clicks_the_search_button() throws Throwable {
		  // driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		 driver.findElement(By.xpath("/html/body/app-root/div/app-recent-movie/div[1]/span[2]")).click();
	}

	@Then("^User gets the movie details$")
	public void user_gets_the_movie_details() throws Throwable {
		System.out.println("Movie details exist");
	}

}
