package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {
			2621455L, 	2621454L, 2621451L, 2621450L, 2621449L
	};
	
	@Test
	public void testGetListWithPaging() {
//		List<ReplyVO> list = 
//				mapper.getListWithPaging(new Criterial(), 2621455L);
//		
//		for(ReplyVO vo : list)
//			log.info(vo);
		
		
		mapper.getListWithPaging(new Criterial(), 2621455L)
		.forEach( list -> log.info(list));
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(3L));
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(1L));
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = ReplyVO.builder()
						.reply("댓글수정")
						.rno(2L)
						.build();
		mapper.update(vo);
						
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = ReplyVO.builder()
						.bno(bnoArr[i % 5])
						.reply("댓글테스트" + i)
						.replyer("댓글자" + i)
						.build();
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testCreate2() {
		
			ReplyVO vo = ReplyVO.builder()
						.bno(2621455L)
						.reply("댓글테스트4")
						.replyer("댓글자4")
						.build();
			mapper.insert(vo);
		
	}
	
	
	
	@Test
	public void testMapper() {
		log.info(">>>>>>>>>>>>>" + mapper);
	}
	
	

}
