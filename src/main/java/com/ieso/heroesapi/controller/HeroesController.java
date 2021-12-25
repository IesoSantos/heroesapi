/**
 * 
 */
package com.ieso.heroesapi.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieso.heroesapi.model.Heroes;
import com.ieso.heroesapi.repository.HeroesRepository;
import com.ieso.heroesapi.service.HeroesService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ieso.heroesapi.constants.HeroesConstants.HEREOES_ENDPOINT_LOCAL;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@Slf4j
public class HeroesController {
   
	HeroesService heroesService;
	HeroesRepository heroesRepository;
	private static final Logger logger = 
			org.slf4j.LoggerFactory.getLogger(HeroesController.class);
	
	public HeroesController (HeroesService heroesService, HeroesRepository heroesRepository) {
		this.heroesService = heroesService;
		this.heroesRepository = heroesRepository;
	}
	
	@GetMapping(HEREOES_ENDPOINT_LOCAL)
	public Flux<Heroes> getAllItems(){
		log.info("Requisitando a lista de todos heróis");
		return heroesService.findAll();
	}
	
	@GetMapping(HEREOES_ENDPOINT_LOCAL+"/id")
	public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id){
		log.info("Requisitando o herói com o id{}",id);
		return heroesService.findByIdHero(id)
				.map((item)-> new ResponseEntity<>(item, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping(HEREOES_ENDPOINT_LOCAL)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Heroes> createHero(@RequestBody Heroes hero){
	log.info("Um novo herói criado");
	return heroesService.save(hero);
	}
	
	@DeleteMapping(HEREOES_ENDPOINT_LOCAL+"/id")
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Mono<HttpStatus> deleteByIdHero(@PathVariable String id){
		heroesService.deleteByIdHero(id);
		log.info("Apagando o herói de id {}", id);
		return Mono.just(HttpStatus.NOT_FOUND);
	}
}
