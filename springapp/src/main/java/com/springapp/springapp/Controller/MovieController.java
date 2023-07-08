package com.springapp.springapp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.springapp.Movie;
import com.springapp.springapp.MovieService;


@RestController
@CrossOrigin(origins="https://8081-fecfecbdcfcdafbecacdccdbbeeaeaadbdbabf.project.examly.io/")
@RequestMapping
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	//Post a new movie********************************
	
	@PostMapping("/POST/movie")
	public ResponseEntity<?> addNewMovie(@RequestBody Movie movie){
		
		return movieService.addMovieService(movie);
	}
	
	//GET ALL MOVIES***************************************************
	
	@GetMapping("/GET/movie")
	public ArrayList<Movie> showAllMovies(){
		return movieService.showAllMovieService();
		
	}
	
	//GET A MOVIE BY MOVIE ID****************************************
	
	@GetMapping("/GET/movie/{id}")
	public ResponseEntity<?> showMovieById(@PathVariable long id){
		
		return movieService.showMovieByIdService(id);
	}
}

//Somnath mandal