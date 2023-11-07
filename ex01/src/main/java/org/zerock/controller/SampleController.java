package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
   
	@GetMapping("/ex06/{name}/{age}")
	public String ex06(@PathVariable("name") String name, @PathVariable("age") int age) {
		log.info("name >> " + name);
		log.info("age >> " + age);
		return "ex06";
	}

	
	@GetMapping("/ex05")
	public String ex05(String name, int age, RedirectAttributes rttr) {
		log.info(name);
		log.info(age);
		
		rttr.addAttribute("name", name);
		rttr.addAttribute("age", age);
		
		rttr.addAttribute("name2", name);
		rttr.addAttribute("age2", age);
		return "ex05";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, Integer page, Model model) {
		log.info(dto);
		log.info(page);
		model.addAttribute("page", page);
		return "sample/ex04";
	}
	
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list >> " + list);
		return "ex02Bean";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name2, // @RequestParam 를 사용하면 ("name")괄호안에 값이 일치하면 변수명이 달라도 대입된다.
			@RequestParam("age") int age2) { // RequestParam를 사용하지 않으면 입력값의 이름과 변수명이 동일해야한다.(일반적으로 이방법을 많이 사용!)
//		public String ex02(String name, int age) {
		log.info("name >> " + name2);
		log.info("age >> " + (age2+10));
		return "ex02";
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto, Model model) { // SampleDTO랑 타입일치 필수!!
		log.info("dto >> " +dto);
		log.info("dto >> " +dto.getName());
		log.info("dto >> " +(dto.getAge()+10));
		model.addAttribute("dto", dto);
		return "ex01";
	}
	
   @RequestMapping("")
   public void basic2() {
      log.info("basic........................");
   }
   
  // @RequestMapping(value = "/basic", method = RequestMethod.GET)
   @GetMapping(value = "/basic")
   public void basic() {
	   log.info("basic....get");
   }
   
//   @RequestMapping(value = "/basic", method = RequestMethod.POST)
   @PostMapping("/basic")
   public void basic3() {
	   log.info("basic....post");
   }
   
//   @RequestMapping(value = "/basic", method = RequestMethod.DELETE)
   @DeleteMapping("/basic")
   public void basic4() {
	   log.info("basic....delete");
   }
   @RequestMapping("first")
   public void first() {
      log.info("first........................");
   }
   @RequestMapping("second")
   public void second() {
      log.info("second........................");
   }
}