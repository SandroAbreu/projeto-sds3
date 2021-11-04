package com.sda.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sda.dsvendas.dto.SaleSucessDTO;
import com.sda.dsvendas.dto.SaleSumDTO;
import com.sda.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{
	
	@Query("SELECT new com.sda.dsvendas.dto.SaleSumDTO(obj.seller, SUM (obj.amount)) "
	+ " FROM Sale AS obj GROUP BY obj.seller")
	
	List<SaleSumDTO> amountGroupeBySeller();
	
	@Query("SELECT new  com.sda.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
	     + " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupeBySeller();
}
