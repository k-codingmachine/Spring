package com.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criterial;
import com.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceImplTests {
	
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
						.title("새로 작성하는 글")
						.content("새로 작성하는 내용")
						.writer("newbie")
						.build();
		boardService.register(board);
	}
	
	@Test
	public void testGetList() {
		Criterial cri = new Criterial();
		boardService.getList(cri)
					.forEach(board->log.info(board));
	}
	
	@Test
	public void testGetByBno() {
		boardService.get(1L);
	}
	
	@Test
	public void testModify() {
		BoardVO board = BoardVO.builder()
						.bno(2L)
						.title("수정")
						.content("수정")
						.writer("수정")
						.build();
		boolean result = boardService.modify(board);
		log.info("result : " + result);
	}
	
	@Test
	public void testDelete() {
		boolean result = boardService.remove(1L);
		log.info("result : " + result);
	}
	
}
