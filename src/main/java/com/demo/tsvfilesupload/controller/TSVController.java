package com.demo.tsvfilesupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.tsvfilesupload.helper.TSVHelper;
import com.demo.tsvfilesupload.message.ResponseMessage;
import com.demo.tsvfilesupload.service.TSVService;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/tsv")
public class TSVController {

  @Autowired
  TSVService fileService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (TSVHelper.hasCSVFormat(file)) {
      try {
        Float totalSaleValue = fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename() + " Total sale value :: "+totalSaleValue;
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
    	  e.printStackTrace();
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload a tsv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

}
