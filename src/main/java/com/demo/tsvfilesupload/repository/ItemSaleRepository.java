package com.demo.tsvfilesupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.tsvfilesupload.model.ItemSales;

public interface ItemSaleRepository extends JpaRepository<ItemSales, Long> {
}
