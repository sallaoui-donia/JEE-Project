package com.donia.Cuisine.italienne;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.donia.Cuisine.italienne.entities.tabl;
import com.donia.Cuisine.italienne.repos.tablRepository;
import com.donia.Cuisine.italienne.entities.dessert;
import com.donia.Cuisine.italienne.entities.met;
import com.donia.Cuisine.italienne.repos.metRepository;
@SpringBootTest
class CuisineItalienne1ApplicationTests {

	@Autowired
	private tablRepository tablRepository;
	@Test
	public void testCreateTabl() {
	tabl tb1 = new tabl(1,"double", (float) 2.400);
	tablRepository.save(tb1);
	}
	
	@Test
	public void testFindtab()
	{ tabl tb1 = tablRepository.findById(1).get(); System.out.println(tb1);
	}
	@Test
	public void testUpdatetabl()
	{ tabl p = tablRepository.findById(1).get();
	p.setNbCouvert(40); 
	tablRepository.save(p);
	}
	@Test
	public void testDeletetabl()
	{ tablRepository.deleteById(2);;
	}
	@Test
	public void testListerToustabl()
	{
	List<tabl> tabs = tablRepository.findAll();
	for (tabl tabl : tabs)
	{
	System.out.println(tabl);
	}
	}
	
	@Autowired
	private metRepository metRepository;
	@Test
	public void testCreatemet() {
	
	metRepository.save(new dessert("chocolat","35dt") );
	}
	
	
}
