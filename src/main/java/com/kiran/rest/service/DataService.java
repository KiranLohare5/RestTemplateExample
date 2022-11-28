package com.kiran.rest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kiran.rest.entity.PostValues;
import com.kiran.rest.entity.UserValues;

@Service
public class DataService 
{
	private final RestTemplate restTemplate;
	
	@Autowired
	public DataService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<PostValues> postApi()
	{
		ResponseEntity<PostValues[]> posts= restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", PostValues[].class);
		PostValues[] postValues = posts.getBody();
		List<PostValues> postsList = Arrays.asList(postValues);
		return postsList;
	}
	
	public List<UserValues> userApi()
	{
		ResponseEntity<UserValues[]> users = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", UserValues[].class);
		UserValues[] userValues = users.getBody();
		List<UserValues> usersList=Arrays.asList(userValues);
		return usersList;
	}
	
}
