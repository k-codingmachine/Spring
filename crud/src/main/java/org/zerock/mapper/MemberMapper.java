package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.MemberVO;

public interface MemberMapper {

	public List<MemberVO> getList();
	
	public void insert(MemberVO vo);
	
	public MemberVO read(Long bno);
	
	public int delete(Long bno);

	public int update(MemberVO vo);
}
