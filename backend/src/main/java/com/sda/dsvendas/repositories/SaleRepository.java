package com.sda.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{

}
