package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criterial;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageDTO;
import org.zerock.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member/*")
@Log4j
@RequiredArgsConstructor 
//@AllArgsConstructor
public class MemberController {
	
	
	private final MemberService memberService;
	
	
	@GetMapping("/list")
	public void list(Criterial cri, Model model) {
		model.addAttribute("list", memberService.getList());
		model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal(cri)));
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(MemberVO vo) {
		log.info("register : " + vo);
		memberService.register(vo);
	
		return "redirect:/member/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long bno,@ModelAttribute("cri")Criterial cri,Model model) {
		log.info("/get or modify");
		
		model.addAttribute("member", memberService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(MemberVO member, @ModelAttribute("cri")Criterial cri,  RedirectAttributes rttr) {
	    log.info("modify: " + member);
	    if(memberService.modify(member)) {
			rttr.addFlashAttribute("result", "success");
	    }
	    
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
	    return "redirect:/member/list";
	}
	
	@GetMapping("/remove")
	public String remove(Long bno, @ModelAttribute("cri")Criterial cri, RedirectAttributes rttr) {
		log.info("remove");
		if(memberService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/member/list";
	}
	
	
	
}
