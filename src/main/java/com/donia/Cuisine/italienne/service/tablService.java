package com.donia.Cuisine.italienne.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donia.Cuisine.italienne.entities.tabl;
import com.donia.Cuisine.italienne.repos.tablRepository;
import com.donia.Cuisine.italienne.DTO.tabRequest;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.tabl;
@Service
public class tablService {

	private tablRepository repotable;
	private ModelMapper mapper = new ModelMapper();
@Autowired
	public tablService(tablRepository repotable) {
		super();
		this.repotable = repotable;
	}
	

public List<tabResponse> getAllEntities() {
	// TODO Auto-generated method stub
	
	       List<tabl> tables = repotable.findAll();
	       List<tabResponse> reponses = new ArrayList<>();
	       for (tabl table:tables) {
	    	   reponses.add(mapper.map(table, tabResponse.class)); } 
   return reponses;
}
public tabResponse getEntityById(Integer id) {
	
	Optional<tabl> opt = repotable.findById(id);
	tabl entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("table with this Id is not found");
	return mapper.map(entity, tabResponse.class);
	
}

public tabResponse createtable(tabRequest request) {
	tabl tablerequest = mapper.map(request, tabl.class);
	
	 repotable.save(tablerequest);
return mapper.map(tablerequest, tabResponse.class);
}

public tabResponse modifytable(Integer id, tabRequest tableresquest) {
	tabResponse tablereponse = this.getEntityById(id);
	tabl  oldTbale = mapper.map(tablereponse, tabl.class);
	tabl newEntity = mapper.map(tableresquest, tabl.class);
 	if(newEntity.getNumero() != 0)
		oldTbale.setNumero(newEntity.getNumero());
	
	  if(newEntity.getNbCouvert() != 0)
	  oldTbale.setNbCouvert(newEntity.getNbCouvert());
	 
	if(newEntity.getSupplement() != 0)
		oldTbale.setSupplement(newEntity.getSupplement());
	if(newEntity.getType() != null)
		oldTbale.setType(newEntity.getType());

	 repotable.save(oldTbale);
  return mapper.map(tableresquest, tabResponse.class);
}

public tabResponse deletetable(Integer id) {
	tabResponse entity = this.getEntityById(id);
	repotable.deleteById(id);
	return entity;
}
public tabl  findbynumero(int numero){
	Optional<tabl> opt = repotable.findByNumero(numero);
	tabl entity;
	if(opt.isPresent())
		entity= opt.get();
	else
		throw new NoSuchElementException("table with this numero is not found");
	return entity;
	
}



	
}