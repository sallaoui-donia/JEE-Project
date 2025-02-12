package com.donia.Cuisine.italienne.service;

import java.util.List;

import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.entities.met;
import com.donia.Cuisine.italienne.repos.dessertRepository;
import com.donia.Cuisine.italienne.repos.entreRepository;
import com.donia.Cuisine.italienne.repos.metRepository;
import com.donia.Cuisine.italienne.repos.platRepository;
import com.donia.Cuisine.italienne.DTO.metRequest;
import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.entities.met;
import java.util.ArrayList; 
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.DTO.metRequest;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.dessert;
import com.donia.Cuisine.italienne.entities.entree;
import com.donia.Cuisine.italienne.entities.met;
import com.donia.Cuisine.italienne.entities.plat;
import com.donia.Cuisine.italienne.entities.tabl;





@Service
public class metService {

	private metRepository repomet;
	private platRepository repoplat;
	private dessertRepository repodesert;
	private entreRepository repoentre;
	private ModelMapper mapper = new ModelMapper();
	
	
@Autowired
public metService(metRepository repomet, platRepository repoplat, dessertRepository repodesert,
		entreRepository repoentre) {
	super();
	this.repomet = repomet;
	this.repoplat = repoplat;
	this.repodesert = repodesert;
	this.repoentre = repoentre;
}
public List<metResponse> getAllEntities() {

// TODO Auto-generated method stub
  List<met> mets = repomet.findAll();
  List<metResponse> reponses = new ArrayList<>();
  for (met met:mets) {
	   reponses.add(mapper.map(met, metResponse.class)); } 
return reponses; 
}
public metResponse getEntityById(Integer id) {
	Optional<met> opt = repomet.findById(id);
	met entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("met with this Id is not found");
	return mapper.map(entity, metResponse.class);	
}



public metResponse createplat(metRequest request) {
	plat entity = mapper.map(request, plat.class);
	
	entity.setNom(entity.getNom().toUpperCase());
	 repoplat.save(entity);
	 return mapper.map(entity, metResponse.class);
}
public metResponse createdessert(metRequest request) {
	dessert entity = mapper.map(request, dessert.class);
	entity.setNom(entity.getNom().toUpperCase());
	 repodesert.save(entity);
	 return mapper.map(entity, metResponse.class);
}
public metResponse createentree(metRequest request) {
	entree entity = mapper.map(request, entree.class);
	entity.setNom(entity.getNom().toUpperCase());
	 repoentre.save(entity);
	 return mapper.map(entity,metResponse.class);
}

public metResponse modifymet(Integer id, metRequest metrequest) {
	metResponse reponse= this.getEntityById(id);
	met oldmet = mapper.map(reponse, met.class);
	met newEntity = mapper.map(metrequest, met.class);
	if(newEntity.getNom() != null)
		oldmet.setNom(newEntity.getNom().toUpperCase());
	if(newEntity.getPrix() != 0)
		oldmet.setPrix(newEntity.getPrix());
 repomet.save(oldmet);
 return mapper.map(metrequest, metResponse.class);
}

public metResponse deletemet(Integer id) {
	metResponse entity = this.getEntityById(id);
	 repomet.deleteAll(id);
	return entity;
}
	
public met getbynom(String nom) {
 String localnom = nom.toUpperCase();	
	Optional<met> opt = repomet.findByNom(localnom);
	met entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("met with this nom is not found");
	return entity;
}
public metResponse getEntityById1(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

}		
