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

		List<OutputResponse> outputResponses = new ArrayList<OutputResponse>();
		List<UserValues> userApi = service.userApi();
		List<PostValues> postApi = service.postApi();
		for (PostValues postValues : postApi) {
			for (UserValues userValues : userApi) {
				if (userValues.getId().equals(postValues.getId())) {
					outputResponses.add(new OutputResponse(postValues.getTitle(), postValues.getBody(),
							userValues.getAddress().getGeo().getLat(), userValues.getAddress().getGeo().getLng(),
								userValues.getCompany().getName(), userValues.getPhone()));
				}
			}
		}
		return outputResponses;
	}
}
