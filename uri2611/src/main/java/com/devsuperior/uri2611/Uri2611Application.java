package com.devsuperior.uri2611;

import com.devsuperior.uri2611.DTO.MovieMinDTO;
import com.devsuperior.uri2611.Repositories.MovieRepository;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {


	@Autowired
	private MovieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection>list = repository.search1("Action");
		List<MovieMinDTO>result1 = list.stream().map(MovieMinDTO::new).collect(Collectors.toList());

		for(MovieMinDTO obj:result1){
			System.out.println(obj);
		}
		System.out.println("\n\n\n");


		System.out.println("JPQL ");
		List<MovieMinDTO>result2 =repository.search2("Action");
		for(MovieMinDTO obj:result2){
			System.out.println(obj);
		}
	}
}
