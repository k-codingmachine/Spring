package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criterial;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;
	
	@Override
	public List<MemberVO> getList() {
		return memberMapper.getList();
	}

	@Override
	public MemberVO get(Long bno) {
		return memberMapper.read(bno);
	}

	@Override
	public void register(MemberVO member) {
		memberMapper.insert(member);
	}

	@Override
	public boolean modify(MemberVO member) {
		return memberMapper.update(member) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return memberMapper.delete(bno) == 1;
	}

	@Override
	public int getTotal(Criterial cri) {
		return memberMapper.getTotalCount(cri);
	}

}
