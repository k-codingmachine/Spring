package com.ezen.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. 스프링 컨테이너에서 필요한 빈을 요청
		TV tv1 = (TV) factory.getBean("tv");  //(형변환)
		TV tv2 = (TV) factory.getBean("tv");  //(형변환)
//		TV tv = factory.getBean("tv2", LGTV.class);  형변환하지않는 방법!
			
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		
		factory.close(); // 사용후 반드시 닫아준다.
		
		
	}
}

