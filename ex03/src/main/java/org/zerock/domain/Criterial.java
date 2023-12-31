package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criterial {

	private int pageNum;  //page 1page, 2page, 3page
	private int amount;  // page당 data갯수

	private String type; // T(title), C(content), W(writer)
	private String keyword; // 검색내용
	
	public Criterial() {
		this(1,10); 
		System.out.println("----------------");
		System.out.println(pageNum);
		System.out.println(amount);
		System.out.println(type);
		System.out.println(keyword);		
		System.out.println("----------------");
	}

	public Criterial(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	// type=t c w. keyword="서울" ==> String[] str = {"t", "c", "w"} 
	public String[] getTypeArr() {
		return type==null? new String[] {} : type.split("");
	}
	
	
	
	
}
