package com.sda.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sda.dsvendas.dto.SaleDTO;
import com.sda.dsvendas.entities.Sale;
import com.sda.dsvendas.repositories.SaleRepository;
import com.sda.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	
	public Page<SaleDTO> findALL(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

}
