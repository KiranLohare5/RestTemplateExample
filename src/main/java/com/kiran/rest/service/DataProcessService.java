package com.kiran.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.rest.entity.OutputResponse;
import com.kiran.rest.entity.PostValues;
import com.kiran.rest.entity.UserValues;

@Service
public class DataProcessService {
	
	@Autowired
	private DataService service;
	
	public DataProcessService(DataService service) {
		this.service = service;
	}

	public List<OutputResponse> processedData() {
		OutputResponse outputResponse=new OutputResponse();
		List<OutputResponse> outputResponses=new ArrayList<OutputResponse>();
		List<UserValues> userApi = service.userApi();
		List<PostValues> postApi = service.postApi();
		
		for (UserValues userValues : userApi) 
		{
			for (PostValues postValues : postApi) 
			{
				if(userValues.getId().equals(postValues.getId()))
				{
					outputResponse.setTitle(postValues.getTitle());
					outputResponse.setBody(postValues.getBody());
					outputResponse.setLat(userValues.getAddress().getGeo().getLat());
					outputResponse.setLng(userValues.getAddress().getGeo().getLng());
					outputResponse.setCompany(userValues.getCompany().getName());
					outputResponse.setPhone(userValues.getPhone());
				}
				outputResponses.add(outputResponse);
			}
		}
		return outputResponses;
	}
}
