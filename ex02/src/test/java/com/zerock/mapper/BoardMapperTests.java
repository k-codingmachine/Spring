package com.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criterial;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		List<BoardVO> list = mapper.getList();
//		for(BoardVO vo : list)
//			log.info(vo);
		
		mapper.getList().forEach(board-> log.info(board));
		
		
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = BoardVO.builder()
				.title("인서트4")
				.content("인서트 내용2")
				.writer("조운2")
				.build();
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle("테스트 인서트");
//		vo.setContent("테스트 인서트 내용");
//		vo.setWriter("user11");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testinsertSelectKey() {
		BoardVO vo = BoardVO.builder()
				.title("인서트5")
				.content("인서트 내용3")
				.writer("마방")
				.build();
		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = mapper.read(1L);
		log.info("vo >> " + vo);
	}
	@Test
	public void testDelete() {
		mapper.delete(10L);
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = BoardVO.builder()
				.bno(7L)
				.title("수정제목")
				.content("수정내용")
				.writer("수정자")
				.build();
		
		int result = mapper.update(vo);
		log.info("result : " + result);
	}
	
	@Test
	   public void testGetPaging() {
	      Criterial cri = new Criterial();
	      // 10개씩 3페이지
	      cri.setPageNum(3);
	      cri.setAmount(10);
	      
	      List<BoardVO> list = mapper.getListWithPaging(cri);
	      list.forEach(board -> log.info(board.getBno()));
	   }
	
	
	
	
	
	
	
	
}
