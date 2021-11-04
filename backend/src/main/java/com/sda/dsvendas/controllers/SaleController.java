package com.sda.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.dsvendas.dto.SaleDTO;
import com.sda.dsvendas.dto.SaleSumDTO;
import com.sda.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")

public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findALL(Pageable pageable){
		Page<SaleDTO> list = service.findALL(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupeBySeller();
		return ResponseEntity.ok(list);
	}
}
