package edu.kh.project.member.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember (email, pw)
	 * @return email, pw가 일치하는 회원정보 또는 null
	 */
	Member login(Member inputMember);

	
	/** 회원가입 서비스
	 * @param inputMember
	 * @return
	 */
	int signUp(Member inputMember);
}
