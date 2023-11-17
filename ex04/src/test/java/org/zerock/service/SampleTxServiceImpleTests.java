package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceImpleTests {

	@Autowired
	private SampleTxServiceImple serviceImple;
	
	@Test
	public void test() {
		String str = "행정전산망 새올아행정전않아";
		
		log.info("length >> " +str.getBytes().length);
		
		serviceImple.addData(str);
	}
}
