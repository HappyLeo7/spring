package com.keduit.service;

public class SampleServiceIpml implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		
		return Integer.parseInt(str1)+Integer.parseInt(str2);
	}

}
