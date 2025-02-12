package com.donia.Cuisine.italienne.service;

import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donia.Cuisine.italienne.entities.ticket;
import com.donia.Cuisine.italienne.repos.metRepository;
import com.donia.Cuisine.italienne.repos.tablRepository;
import com.donia.Cuisine.italienne.repos.ticketRepository;
import com.donia.Cuisine.italienne.repos.clientRepository;

import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.ticket;
import com.donia.Cuisine.italienne.service.ticketService;
import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.client;
import com.donia.Cuisine.italienne.entities.met;
import com.donia.Cuisine.italienne.entities.tabl;
import com.donia.Cuisine.italienne.entities.ticket;
import de.tekup.project.Repository.metRepisotery;
import de.tekup.project.Repository.TableRepository;

import de.tekup.project.Repository.clientRepository;

@Service
public class ticketService {

private ticketRepository repoticket;
private tablRepository repotable;
private clientRepository repoclient;
private metRepository repomet;
private ModelMapper mapper = new ModelMapper();
	
@Autowired
	public ticketService( ticketRepository repoticket ,  tablRepository  repotable , clientRepository repoclient,
		metRepository repomet)
{
	super();
	this.repoticket = repoticket;
	this.repotable = repotable;
	this.repoclient = repoclient;
	this.repomet = repomet;
}
	
	public List<ticket> getAllEntities() {
		// TODO Auto-generated method stub
		return repoticket.findAll();
	}
	public ticket getEntityById(Integer id) {
		Optional<ticket> opt = repoticket.findById(id);
		ticket entity;
		if(opt.isPresent())
			entity= opt.get();
		else
			throw new NoSuchElementException("met with this Id is not found");
		return entity;	
	}


	public ticket createTicket(ticket entity) {
        Instant now = Instant.now();
        entity.setTable(now);
		return repoticket.save(entity);
	}

	public ticket modifyticket(Integer id, ticket newEntity) {
		ticket oldmet= this.getEntityById(id);
		Instant now = Instant.now();
		if(newEntity.getNumero() != 0)
	    oldmet.setNumero(newEntity.getNumero());
		oldmet.setDate(now);
		return repoticket.save(oldmet);
	}

	public ticket deleteticket(Integer id) {
		ticket entity = this.getEntityById(id);
		repoticket.deleteById(id);
		return entity;
	}
		
    public tabResponse mostReservedTable(){
        Map<Long,Integer> listTableWithkey=new HashMap<>();
        List<tabl> tables=repotable.findAll();
        for(tabl table:tables){
            listTableWithkey.put(table.getNumero(),table.getTickets().size());
        }
        Long toptable= listTableWithkey.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        tabl table=repotable.findById(toptable).get();
        return mapper.map(table,tabResponse.class);
       }
       public String RevenuejSm(){
        List<ticket> tickets=repoticket.findAll();
        double revenueJours=0,revenueSemaine=0,revenuemois=0;
        for (ticket ticket:tickets){
            if (ticket.getDate().isAfter(Instant.now().minus(Period.ofDays(30)))){
                revenuemois=revenuemois+ticket.getAddition();
            }
            if (ticket.getDate().isAfter(Instant.now().minus(Period.ofDays(7)))){
                revenueSemaine=revenueSemaine+ticket.getAddition();
            }
            if (ticket.getDate().isAfter(Instant.now().minus(Period.ofDays(1)))){
                revenueJours=revenueJours+ticket.getAddition();
            }
        }

return "Revenue moins derniere :"+revenuemois+"\n Revenue semaine derniere :"+revenueSemaine+"\n Revenue jour derniere :"+revenueJours;
       }
	
   public Instant mostresrvedday(int id) {
           Optional  <client> client=repoclient.findById(id);
           Instant dateplusrepter=Instant.now();
           if(client.isPresent()){
               dateplusrepter= client.get().getTickets().stream().map(ticket->tickets.getDate())
                       .collect(Collectors.groupingBy(I->I, Collectors.counting()))
                       .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
           }else throw new NoSuchElementException("client id est incorrect ");
           return dateplusrepter;
       }
   
   
   public double revenudansperiode(Instant debutperiode, Instant finperiode) {
       List<ticket> tickets=repoticket.findAll();
       double somme=0;
       for(ticket ticket:tickets){
           if(ticket.getDate().isAfter(debutperiode)&&ticket.getDate().isBefore(finperiode)){
               somme=ticket.getAddition()+somme;
           }
       }
       return somme;
   }
   public client clientplusFidel(Instant debutperiode,Instant finperiode){
       List<ticket>tickets=repoticket.findAll();
       List<ticket>ticketss=new ArrayList<>();

       for(ticket ticket:tickets){
           if(ticket.getDate().isAfter(debutperiode)&&ticket.getDate().isBefore(finperiode)){
               ticketss.add(ticket);
           }
       }
       List<client> cl=  tickets.stream().map(tic->tic.getClient()).collect(Collectors.toList());

       client fidel=cl.stream().collect(Collectors.groupingBy(l->l, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
       return fidel;
   }
   public metResponse mostBuyedPlat(Instant begin,Instant end){
       List<ticket> tickets=repoticket.findAll();
       List<Long> idList=new ArrayList<>();
       for (ticket ticket:tickets){
           //check if ticket is in the given time interval
           if(ticket.getDate().isAfter(begin)&&ticket.getDate().isBefore(end)){

               for (met met:ticket.getMets()){
                   //filtering Plat out from list of mets
                   if(met instanceof com.donia.Cuisine.italienne.entities.plat){
                       idList.add(met.getId());
                   }
               }
           }
       }
       Long metid= idList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        .entrySet()
        .stream()
         .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
       met met=repomet.findById(metid).get();
       return mapper.map(met,metResponse.class);
   }
}
