package com.kiran.rest.entity;

public class OutputResponse {
	private String title;
	private String body;
	private String lat;
	private String lng;
	private String company;
	private String phone;
	
	
	
	public OutputResponse(String title, String body, String lat, String lng, String company, String phone) {
		this.title = title;
		this.body = body;
		this.lat = lat;
		this.lng = lng;
		this.company = company;
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "OutputResponse [title=" + title + ", body=" + body + ", lat=" + lat + ", lng=" + lng + ", company="
				+ company + ", phone=" + phone + "]";
	}
}
