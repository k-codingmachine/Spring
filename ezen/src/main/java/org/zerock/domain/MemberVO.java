package org.zerock.domain;
/*
 * create table ezen(
    name varchar2(20),
    phone varchar2(20),
    address varchar2(100),
    email varchar2(30) primary key,
    age number(20)
);

 */

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter 
@Getter 
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

	private Long bno;
	private String name;
	private String phone;
	private String address;
	private String email;
	private Integer age;
	
}
