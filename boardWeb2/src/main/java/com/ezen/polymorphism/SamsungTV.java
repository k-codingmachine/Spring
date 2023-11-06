package com.ezen.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV{
	
//	@Autowired 객체중에 타입이 일치하는것 알아서 객체생성(중복시 동작x)
	@Qualifier("apple") // 중복시 사용(하나 고른다)
	private Speaker speaker;
	
	private int price;
	
	
public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//	public void initMethod() {
//		System.out.println("생성자 initMethod ==> 초기화 문장 기입");
//	}
//	public void destroyMethod() {
//		System.out.println("객체 소멸시 구동");
//
//	}
//	
	public SamsungTV() {
		System.out.println("생성자 SamsungTV");
		System.out.println("speaker :" + speaker);
	}
	
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("생성자 SamsungTV(speaker)");
	}
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("생성자 SamsungTV(speaker) : " + price);
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn : " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");		
	}

	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV volumeUp");		
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV volumeDown");		
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}

}
