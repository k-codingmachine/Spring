package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("SonySpeaker 생성자");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker volumeDown");		
	}

}
