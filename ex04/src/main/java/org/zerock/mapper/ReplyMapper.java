package org.zerock.mapper;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
 
	public int insert(ReplyVO vo); // create
	public ReplyVO read(Long rno); // read
	public int update(ReplyVO vo); // update
	public int delete(Long rno); // delete

	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criterial cri,
			@Param("bno") Long bno
			);
	
	public int getCountByBno(Long bno);
}
