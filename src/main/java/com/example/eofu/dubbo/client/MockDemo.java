package com.example.eofu.dubbo.client;


import com.example.eofu.dubbo.api.HelloService;

public class MockDemo implements HelloService {
	@Override
	public String syaHello(String str) {
		return "服务繁忙：" + str;
	}
}
