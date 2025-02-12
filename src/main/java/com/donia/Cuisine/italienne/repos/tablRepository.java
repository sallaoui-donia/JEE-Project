package com.donia.Cuisine.italienne.repos;
import com.donia.Cuisine.italienne.entities.tabl;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface tablRepository extends JpaRepository<tabl, Integer>  {

	Optional<tabl> findByNumero(int numero);

}
