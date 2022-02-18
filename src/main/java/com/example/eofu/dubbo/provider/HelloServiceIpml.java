package com.example.eofu.dubbo.provider;


import com.example.eofu.dubbo.api.HelloService;

public class HelloServiceIpml implements HelloService {
	@Override
	public String syaHello(String str) {
		return "HelloService:" + str;
	}
}
