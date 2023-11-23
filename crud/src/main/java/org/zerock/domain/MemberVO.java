package org.zerock.domain;

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
