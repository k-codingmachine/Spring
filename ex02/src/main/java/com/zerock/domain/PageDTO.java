package com.zerock.domain;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criterial cri;
									//125
	public PageDTO(Criterial cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < endPage) {
			endPage  = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	
	}
}
