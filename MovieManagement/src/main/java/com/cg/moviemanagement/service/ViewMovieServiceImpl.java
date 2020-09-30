package com.cg.moviemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.util.MovieConstants;

@Transactional
@Service
public class ViewMovieServiceImpl implements ViewMovieService{

	@Autowired
	private MovieDao dao;
	
	/*********************************************************************************************************************
	 * Method: getMovies 
	 * Description: To give a list of movies by taking movie name/movie director/ movie genre as input.
	 * @param searchStr: Movie's name/ movie genre/ movie director's name.
	 *              Created By - prameela 
	 *              Created Date - 26-SEP-2020
	 * @throws MovieNotFoundException - When a movie is search for which does not exist in database, exception is thrown.
	 *********************************************************************************************************************/

	@Override
	public List<Movie> searchMovies(String searchStr) throws MovieNotFoundException {
		if(dao.searchMovies(searchStr).size()==0)
			throw new MovieNotFoundException("Movie with Name "+searchStr+" not found");
	   else
		return dao.searchMovies(searchStr);
	}

	

	/*********************************************************************************************************************
	 * Method: viewMovies 
	 * Description: To give a list of movies active in database.
	 *              Created By - prameela
	 *              Created Date - 26-SEP-2020
	 * @throws MovieNotFoundException 
	 *********************************************************************************************************************/
	@Override
	public List<Movie> viewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		movielst.sort((m1,m2)->m1.getMovieName().compareTo(m2.getMovieName()));
		return movielst;
	}


	/*********************************************************************************************************************
	 * Method: viewNewMovies 
	 * Description: To give a list of new movies active in database.
	 *              Created By - 
	 *              Created Date - 26-SEP-2020
	 * @throws MovieNotFoundException 
	 *********************************************************************************************************************/
	@Override
	public List<Movie> viewNewMovies() throws MovieNotFoundException {
		List<Movie> movielst = dao.viewActiveMovies();
		if(movielst.isEmpty())
			throw new MovieNotFoundException(MovieConstants.MOVIE_NOT_AVAILABLE);
		List<Movie> newMovies = new ArrayList<>();
		newMovies.addAll(getMovies(movielst, MovieConstants.ENGLISH));
		newMovies.addAll(getMovies(movielst, MovieConstants.HINDI));
		newMovies.addAll(getMovies(movielst, MovieConstants.TELUGU));
		return newMovies;
	}
	
	
	
	
	
	public List<Movie> getMovies(List<Movie> movielst, String language){
		return movielst.stream().filter(m->m.getLanguage().equalsIgnoreCase(language)).sorted((m1,m2)->m2.getReleaseDt().compareTo(m1.getReleaseDt()))
				.limit(2).collect(Collectors.toList());
	}

	@Override
	public boolean addmovie(Movie movie) {
		boolean b=dao.addMovie(movie);
		if(b==true)
		{
			System.out.println("Added SucessFully");
		    return true;
		}
		else
		{
			System.out.println("Not Added");
			return false;
		}
		
	}

	
	
	
	 
}
