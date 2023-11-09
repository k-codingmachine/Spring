package com.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zerock.domain.BoardVO;
import com.zerock.mapper.BoardMapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
	
		log.info("getList..........>>" );

		return boardMapper.getList();
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..........>>" );
		return boardMapper.read(bno);
		
	}

	@Override
	public void register(BoardVO board) {
		
		log.info("register..........>>" + board);
		boardMapper.insertSelectKey(board);
	}
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..........>>");
		
		return boardMapper.update(board) == 1?  true :  false;
		
	}
	@Override
	public boolean remove(Long bno) {
		log.info("modify..........>>");
		
		
		return boardMapper.delete(bno) == 1;
	}



}
