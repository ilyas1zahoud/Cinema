package com.ilem;

import com.ilem.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  CinemaApplication implements CommandLineRunner {



	@Autowired
	private ICinemaInitService cinemaInitService;


	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.cinemaInitService.initVilles();
	//	this.cinemaInitService.initCinemas();
//		this.cinemaInitService.initSalles();
//		this.cinemaInitService.initPlaces();
//		this.cinemaInitService.initSeances();
//		this.cinemaInitService.initFilms();
//		this.cinemaInitService.initCategories();
		this.cinemaInitService.initProjections();
//		this.cinemaInitService.initTickets();
	}
}
