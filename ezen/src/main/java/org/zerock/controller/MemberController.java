package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
@RequiredArgsConstructor  
//@AllArgsConstructor
public class MemberController {
	
	private final MemberService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(MemberVO vo, RedirectAttributes rttr) {
		log.info("register : " + vo);
		service.register(vo);
		rttr.addFlashAttribute("result", vo.getBno());
	
		return "redirect:/member/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long bno,Model model) {
		log.info("/get or modify");
		
		model.addAttribute("member", service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO member) {
	    log.info("modify: " + member);
	    service.modify(member);
	    return "redirect:/member/list";
	}
	
	@GetMapping("/remove")
	public String remove(Long bno) {
		log.info("remove");
		service.remove(bno);
		return "redirect:/member/list";
	}
	

	
	
	
}
