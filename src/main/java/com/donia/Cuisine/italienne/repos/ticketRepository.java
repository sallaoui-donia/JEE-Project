package com.donia.Cuisine.italienne.repos;
import com.donia.Cuisine.italienne.entities.ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface ticketRepository extends JpaRepository<ticket,Integer > {
	
    @Query("select Day(DATE(t.date)) as date, sum(t.addition) as revenue "
            + "FROM ticket t " + "group by date")
    List<String> getRevenueByDay();

    @Query("select Week(DATE(t.date)) as date, sum(t.addition) as revenue "
            + "FROM ticket t " +"group by date")
    List<String> getRevenueByWeek();
    @Query("select Month(DATE(t.date)) as date, sum(t.addition) as revenue "
            +
            "FROM ticket t " + "group by date")
           
    List<String> getRevenueByMonth();

    @Query("select sum(t.addition) as revenue "
            +
            "FROM ticket t "  + "where t.date = :dr ")
    List<String> getRevenueByDate(@Param("dr")String date);

}
