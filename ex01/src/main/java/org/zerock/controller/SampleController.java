package org.zerock.controller;


import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController    //(@Controller + @RequestBody(@ResponseBody))
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
   
	@PostMapping("/exUploadPost")
	public void exUploadPost(@RequestParam("files") ArrayList<MultipartFile> files) {
	    files.forEach(file -> {
	        log.info("------------------------");
	        log.info("name : " + file.getOriginalFilename());
	        log.info("size : " + file.getSize());
	    });
	}

	
	
	@GetMapping("/exUpload")
	public void exUpload() {
	    log.info("/exUpload....");
	}

	
	
	@GetMapping("/ex10")
	public ResponseEntity<String> ex10(){
		log.info("ex10");
		String msg = "{\"name\" : \"홍길동\"}";
				
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/ex09")
	public  void ex09(@RequestBody SampleDTO dto) {
		log.info("ex09.....");
		log.info(dto.getName());
		log.info(dto.getAge());
	}
	
	
	@GetMapping("/ex08")
	public @ResponseBody SampleDTO ex08() {
//	public  SampleDTO ex08() { @RestController 가 설정되어있으면 @ResponseBody를 뺄수있다.
		log.info("ex08.....");
		SampleDTO dto = new SampleDTO();
		dto.setName("조조");
		dto.setAge(20);
		
		return dto;
	}
	
	
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