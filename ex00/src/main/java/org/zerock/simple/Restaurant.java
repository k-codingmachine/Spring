package org.zerock.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor // 매개변수의 생성자 생성(모든 매개변수)
@NoArgsConstructor // default 생성자 생성
public class Restaurant {
	
	@Autowired
	private Chef chef;
}
