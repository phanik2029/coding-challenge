package com.demo.tsvfilesupload.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.tsvfilesupload.helper.TSVHelper;
import com.demo.tsvfilesupload.model.ItemSales;
import com.demo.tsvfilesupload.repository.ItemSaleRepository;

@Service
public class TSVService {
  @Autowired
  ItemSaleRepository repository;

  public Float save(MultipartFile file) {
    try {
      //List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      List<ItemSales> itemSales = TSVHelper.tsvToTutorials(file.getInputStream());
      Iterator<ItemSales> salesiterator = itemSales.iterator();
      Float totalSaleValue = 0.0f;
      while (salesiterator.hasNext()) {
    	  ItemSales saleRecord = salesiterator.next();
          totalSaleValue = totalSaleValue + (saleRecord.getItemprice() * saleRecord.getItemcount());
      }
      repository.saveAll(itemSales);
      return totalSaleValue;
    } catch (IOException e) {
      throw new RuntimeException("fail to store tsv data: " + e.getMessage());
    }
  }

}
