package com.sda.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.dsvendas.dto.SaleDTO;
import com.sda.dsvendas.dto.SaleSucessDTO;
import com.sda.dsvendas.dto.SaleSumDTO;
import com.sda.dsvendas.entities.Sale;
import com.sda.dsvendas.repositories.SaleRepository;
import com.sda.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	
	public Page<SaleDTO> findALL(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	@Transactional(readOnly = true)
	public 	List<SaleSumDTO> amountGroupeBySeller(){
		return repository.amountGroupeBySeller();
	}
	
	@Transactional(readOnly = true)
	public 	List<SaleSucessDTO> sucessGroupeBySeller(){
		return repository.sucessGroupeBySeller();
    }
}
	
	
	
