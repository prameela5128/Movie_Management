package com.cg.movieBDD.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/Feature/ViewMovies.feature", 
//glue = {"com.cg.movieBDD.stepdef"},tags = {"@ViewMovies"})

@CucumberOptions(features = "src/test/resources/Feature/SearchMovie.feature", 
glue = {"com.cg.movieBDD.stepdef"},tags = {"@SearchMovie,@MovieNotAvailable"})
public class TestRunner {


}

