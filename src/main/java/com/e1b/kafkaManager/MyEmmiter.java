package com.e1b.kafkaManager;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class MyEmmiter extends SseEmitter{
	
	private SseEmitter e;
	public MyEmmiter(SseEmitter e) {
		this.e = e;
	}
	
	@Override
	public String toString() {
		return this.toString().replaceAll("data:", "");
	}
}
