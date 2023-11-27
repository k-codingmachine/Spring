package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criterial;
import org.zerock.domain.MemberVO;

public interface MemberService {

	public List<MemberVO> getList();
	public MemberVO get(Long bno);
	public void register(MemberVO member);
	public boolean modify(MemberVO member);
	public boolean remove(Long bno);
	public int getTotal(Criterial cri);

}
