package com.demo.tsvfilesupload.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.tsvfilesupload.model.ItemSales;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

public class TSVHelper {
	public static String TYPE = "text/tab-separated-values";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };

	public static boolean hasCSVFormat(MultipartFile file) {

		System.out.println("content type "+file.getContentType());
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}


	public static List<ItemSales> tsvToTutorials(InputStream is) {
	   List<ItemSales> sales = new ArrayList<ItemSales>();
	    try {
	    	BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	    	TsvParserSettings parserSettings = new TsvParserSettings();
	    	
	    	parserSettings.setNumberOfRowsToSkip(1);
	    	parserSettings.setSkipEmptyLines(true);
	    	TsvParser tsvParser = new TsvParser(parserSettings);
	    	List<com.univocity.parsers.common.record.Record> parsedRows = tsvParser.parseAllRecords(fileReader);
	    	for (com.univocity.parsers.common.record.Record record : parsedRows) {
	    		ItemSales sale = new ItemSales(
	  	                  record.getString(0),
	  	                  record.getString(1),
	  	                  record.getFloat(2),
	  	                  Integer.parseInt(record.getString(3)),
	  	                  record.getString(4),
	  	                  record.getString(5));
	    			
	  	            sales.add(sale);
	            
	          }
	    	return sales;
	    } catch (Exception e) {
	      e.printStackTrace();
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }


}
