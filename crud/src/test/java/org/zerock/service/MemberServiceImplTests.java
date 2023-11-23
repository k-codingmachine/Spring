package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceImplTests {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testRegister() {
		MemberVO vo = MemberVO.builder()
				.name("등록")
				.phone("01022224444")
				.address("수원시 ")
				.email("11@gmail.com")
				.age(21)
				.build();
		memberService.register(vo);
	}
	
	@Test
	public void testGetList() {
		memberService.getList()
				.forEach(board -> log.info(board));
	}
	
	@Test
	public void testModify() {
		MemberVO member = MemberVO.builder()
				.bno(29L)
				.name("등록")
				.phone("01022224444")
				.address("수원시 ")
				.email("11@gmail.com")
				.age(21)
				.build();
		
		boolean result  = memberService.modify(member);
		log.info("result >>" + result);
	}
	
	@Test
	public void testDelete() {

		boolean result  = memberService.remove(29L);
		log.info("result >>" + result);
	}
	
	

}
