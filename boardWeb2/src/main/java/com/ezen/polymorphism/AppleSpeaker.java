package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker volumeDown");		
	}

}
