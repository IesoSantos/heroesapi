/**
 * 
 */
package com.ieso.heroesapi.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.ieso.heroesapi.model.Heroes;

/**
 * @author Anderson dos Reis Santos
 *
 */
@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes,String> {

}
