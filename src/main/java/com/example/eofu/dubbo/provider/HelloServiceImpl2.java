package com.example.eofu.dubbo.provider;


import com.example.eofu.dubbo.api.HelloService;

public class HelloServiceImpl2 implements HelloService {

	@Override
	public String syaHello(String str) {
		return "Hello version2.0" + str;
	}
}
