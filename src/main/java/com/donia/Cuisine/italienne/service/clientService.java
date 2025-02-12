package com.donia.Cuisine.italienne.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;  
import java.util.NoSuchElementException;
import java.util.Optional;

import java.util.ArrayList;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.donia.Cuisine.italienne.DTO.clientRequest;
import com.donia.Cuisine.italienne.DTO.clientResponse;
import com.donia.Cuisine.italienne.entities.client;
import com.donia.Cuisine.italienne.entities.ticket;
import com.donia.Cuisine.italienne.repos.clientRepository;

@Service
public class clientService {
	
	private clientRepository reposclient;
	
	private ModelMapper mapper = new ModelMapper();
	
	public clientService (clientRepository reposclient) {
		super();
		this.reposclient = reposclient;
	}
	
	public List<clientResponse> getAllEntities() {
		// TODO Auto-generated method stub
      List<client> clients = reposclient.findAll();
      List<clientResponse>reponses =new ArrayList<>() ;
        for(client client:clients) {
	   
	   reponses.add(mapper.map(client,  clientResponse.class));
	   
   }
    return reponses;

	}
	public clientResponse getEntityById(Integer id) {
		Optional<client> opt = reposclient.findById(id);
		client entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("client with this Id is not found");
		return mapper.map(entity,clientResponse.class);
	}


	public clientResponse createclient(clientRequest request) {
		client entity = mapper.map(request,client.class);
		 reposclient.save(entity);
		 return mapper.map(entity, clientResponse.class);
	}

	public clientResponse modifyclient(Integer id, clientRequest requestc) {		
		clientResponse clientreponse= this.getEntityById(id);
		client oldclien = mapper.map(clientreponse, client.class);
		client newEntity = mapper.map(requestc, client.class);
		if(newEntity.getNom() != null)
			oldclien.setNom(newEntity.getNom());
		if(newEntity.getPrenom() != null)
			oldclien.setPrenom(newEntity.getPrenom());
		if(newEntity.getTelephone()!= null)
			oldclien.setTelephone(newEntity.getTelephone());
		if(newEntity.getCourriel()!= null)
			oldclien.setCourriel(newEntity.getCourriel());
		if(newEntity.getDateDeNaissance()!= null)
			oldclien.setDateDeNaissance(newEntity.getDateDeNaissance());
		 reposclient.save(oldclien);
		 return mapper.map(requestc,  clientResponse.class);
	}

	public clientResponse deletclient(Integer id) {
		clientResponse entity = this.getEntityById(id);
		reposclient.deleteById(id);
		return entity;
	}
}