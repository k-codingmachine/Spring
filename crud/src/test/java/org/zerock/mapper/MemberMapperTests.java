package org.zerock.mapper;

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
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.name("test")
				.phone("010222244444")
				.address("수원시 ")
				.email("sa@gmail.com")
				.age(20)
				.build();

		mapper.insert(vo);
	}
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read(30L);
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
						.bno(30L)
						.name("카리나")
						.phone("01022223333")
						.address("서울 시그니엘")
						.email("ss@gmail.com")
						.age(20)
						.build();
		
		int result = mapper.update(vo);
	}
	
	
	@Test
	public void testDelete() {
		 mapper.delete(31L);
	}
	

}
