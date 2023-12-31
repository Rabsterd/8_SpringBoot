package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{

	
		@Autowired
		private MemberDAO dao;
		
		@Autowired
		private BCryptPasswordEncoder bcrypt;


		@Override
		public Member login(Member inputMember) {
		
			// dao 메서드 호출
			Member loginMember = dao.login(inputMember);
			
			return loginMember;
		}
		
		// 회원 가입 서비스
		@Transactional
		@Override
		public int signUp(Member inputMember) {
			
			// 비밀번호 암호화 (Bcrypt) 후 다시 inputMember 세팅
			
			String encPw = bcrypt.encode(inputMember.getMemberPw());
			inputMember.setMemberPw(encPw);
			
			
			return dao.signUp(inputMember);
			
		}

}
