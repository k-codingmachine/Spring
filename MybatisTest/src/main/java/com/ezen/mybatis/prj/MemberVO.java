package com.ezen.mybatis.prj;
/*
 * 
 *  id number(5) primary key,
    name VARCHAR2(20),
    phone varchar2(20),
    address varchar2(50)
 * 
 * 
 */

import lombok.Data;

@Data
public class MemberVO {
	private int id;
	private String name;
	private String phone;
	private String address;

}
