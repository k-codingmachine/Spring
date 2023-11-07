package com.ezen.mybatis.prj;

import java.util.List;

public interface mapperInterfacce {
	
	
	public MemberVO selectOne(int id);
	public int insertMember(MemberVO mVo);
	public int deleteMember(int id);
	public int updateMember(MemberVO mVo);
	
	public List<MemberVO> selectAll();
}
