package com.ezen.polymorphism;

public class LGTV implements TV {

	public LGTV() {
		System.out.println("생성자 LGTV");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV powerOff");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV volumeUp");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LGTV volumeDown");
		
	}

}
