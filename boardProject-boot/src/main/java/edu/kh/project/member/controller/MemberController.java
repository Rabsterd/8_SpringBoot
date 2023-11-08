package edu.kh.project.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.HttpSession;


@Controller // 요청/응답 클래스 + bean 등록(Spring 관리하는 객체)
@RequestMapping("/member") // 공통된 주소 앞부분 작성, member로 시작하는 요청은 해당 컨트롤러에서 처리
@SessionAttributes({"loginMember"}) // Model의 이름(key)를 적으면 session으로 추가
public class MemberController {
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		if(inputMember.getMemberEmail().equals("user01") &&
				inputMember.getMemberPw().equals("pass01!")){
			
			Member loginMember = new Member();
			loginMember.setMemberEmail("user01");
			loginMember.setMemberNickname("유저일");
			loginMember.setMemberNo(1);
		
			model.addAttribute("loginMember", loginMember);
			
		} else {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호 불일치");
		}
		
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status, HttpSession session) {
		status.setComplete();
		return "redirect:/";
	}
	
	
}
