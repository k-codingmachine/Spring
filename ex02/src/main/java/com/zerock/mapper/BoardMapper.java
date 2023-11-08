package com.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zerock.domain.BoardVO;



public interface BoardMapper {

	// 전체 데이터 조회
//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	
	// insert문 bno값 알 필요없을때
	public void insert(BoardVO vo);
	// insert문 bno값 알 필요있을때
	public void insertSelectKey(BoardVO vo);
	
	
	//bno로 데이터 조회
	public BoardVO read(Long bno);
	
	//bno값의 데이터 삭제
	public int delete(Long bno);
	
	//update
	public int update(BoardVO vo);
}
