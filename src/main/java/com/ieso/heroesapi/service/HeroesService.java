/**
 * 
 */
package com.ieso.heroesapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieso.heroesapi.model.Heroes;
import com.ieso.heroesapi.repository.HeroesRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class HeroesService {

	@Autowired
	private HeroesRepository heroesRepository;
	
	public Flux<Heroes> findAll(){
		return Flux.fromIterable(heroesRepository.findAll());
	}
	
	public Mono< Heroes> findByIdHero(String id){
		return Mono.justOrEmpty(heroesRepository.findById(id));
	}
	
	public Mono <Heroes> save (Heroes heroes){
		return Mono.justOrEmpty(heroesRepository.save(heroes));
	}
	
	public Mono<Boolean> deleteByIdHero(String id){
		heroesRepository.deleteById(id);
		return Mono.just(true);
	}
	
}
