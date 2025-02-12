package com.donia.Cuisine.italienne.repos;
import com.donia.Cuisine.italienne.entities.met;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface metRepository extends JpaRepository<met, String> {
	public  Optional<met> findByNom (String nom);

	public Optional<met> findById(Integer id);

	public void deleteAll(Integer id);
}
