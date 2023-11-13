package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.domain.BoardVO;
import com.zerock.domain.Criterial;
import com.zerock.domain.PageDTO;
import com.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")
	public void list(Criterial cri, Model model) {
		log.info("list >> " + cri);
		
//		cri.setPageNum(11);
//		cri.setAmount(10);		
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 125));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register");
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno()); // addFlashAttribute 한번만 보여준다.(새로고침시 사라짐)
		return "redirect:/board/list";
	}
	
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove");

		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
}
