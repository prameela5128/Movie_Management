package com.cg.moviemanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.service.SearchService;
import com.cg.moviemanagement.util.MovieConstants;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SearchController {
	
	@Autowired
	private SearchService serviceObject;

 	
	
	
	
	
	@CrossOrigin
	@GetMapping("/showsforscreen/{screenname}")
	public List<Show> getShowsForScreen(@PathVariable("screenname") String screenName) throws ShowException
	{
		List<Show> shows = serviceObject.getShows(screenName);
		return shows;
		
	}
	

	
	@CrossOrigin
	@GetMapping("/viewshowsforscreenmoviedt/{screenname}/{movieid}/{searchdt}")
	public List<Show> getShowsForScreenMovieDate(@PathVariable("screenname") String screenName, @PathVariable("movieid") int movieid ,
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt ) throws ShowException
	{
		List<Show> shows = serviceObject.getShows(screenName, searchDt, movieid);
		return shows;
		
	}

	@CrossOrigin
	@GetMapping("/viewshowsforscreendt/{screenname}/{searchdt}")
	public List<Show> getShowsForScreenDate(@PathVariable("screenname") String screenName, 
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt ) throws ShowException
	{
		List<Show> shows = serviceObject.getShows(screenName, searchDt);
		return shows;
		
	}
	
	
	@CrossOrigin
	@GetMapping("/viewshowsfordatemovieid/{movieid}/{searchdt}")
	public List<Show> getShowsForMovieDt( @PathVariable("movieid") int movieid ,
			@PathVariable("searchdt") @DateTimeFormat(pattern="yyyy-M-d") LocalDate searchDt ) throws ShowException
	{
		List<Show> shows = serviceObject.getShows(searchDt, movieid);
		return shows;
		
	}
}
