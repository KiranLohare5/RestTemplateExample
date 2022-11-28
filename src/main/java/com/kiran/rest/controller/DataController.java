package com.kiran.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.rest.entity.OutputResponse;
import com.kiran.rest.service.DataProcessService;

@RestController
public class DataController {
	
	@Autowired
	private DataProcessService processService;

	public DataProcessService getProcessService() {
		return processService;
	}

	public void setProcessService(DataProcessService processService) {
		this.processService = processService;
	}

	@GetMapping("/getData")
	public ResponseEntity<List<OutputResponse>> getData()
	{
		List<OutputResponse> list = processService.processedData();
		if(list!=null)
		{
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}