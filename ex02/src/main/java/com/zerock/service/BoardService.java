package com.zerock.service;

import java.util.List;

import com.zerock.domain.BoardVO;

public interface BoardService {

	
	public List<BoardVO> getList();
	public BoardVO get(Long bno);
	public void register(BoardVO board);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	
	
}
