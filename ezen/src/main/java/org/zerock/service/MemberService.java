package org.zerock.service;

import java.util.List;

import org.zerock.domain.MemberVO;

public interface MemberService{

	public List<MemberVO> getList();
	public MemberVO get(Long bno);
	public void register(MemberVO vo);
	public boolean modify(MemberVO vo);
	public boolean remove(Long bno);
	
}
