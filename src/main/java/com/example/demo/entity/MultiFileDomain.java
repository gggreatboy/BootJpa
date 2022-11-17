package com.example.demo.entity;


import org.springframework.web.multipart.MultipartFile;

public class MultiFileDomain{


	public MultipartFile getMyfile() {
		return myfile;
	}
	public void setMyfile(MultipartFile myfile) {
		this.myfile = myfile;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}

	private MultipartFile myfile;
	private String length;

	
}
