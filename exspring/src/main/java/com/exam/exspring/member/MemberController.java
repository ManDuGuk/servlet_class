package com.exam.exspring.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class MemberController{
	
	@Autowired
	private MemberService memberService; 
	
	@RequestMapping(value="/member/list.do",method=RequestMethod.GET)
	//Map<String,Object> map에서 <String ,Object>는 생략할수도 있다. 
	public String list(Map<String,Object> map){
		
		
			List<MemberVo> list = memberService.selectMemberList();
		    
			map.put("memList", list);
			
			return "member/memList";
		
			

	}
	
	@RequestMapping(value="/member/add.do",method=RequestMethod.GET)
	public String addForm() {
				
       return "member/memAdd";

	}
	
	
	@RequestMapping(value="/member/add.do",method=RequestMethod.POST)
	public String add(MemberVo vo){
		
		
		
		int num = memberService.insertMember(vo);
		
		//뷰이름에 redirect:접두어를 사용하여(포워드가 아닌) 리다이렉트임을 표시
		return "redirect:/member/list.do";
		
	}
	
	
	@RequestMapping(value="/member/edit.do",method=RequestMethod.GET)
	public String editForm(String memId,Map<String,Object> map){
				
		
		MemberVo vo=memberService.selectMember(memId);
		
		map.put("memVo", vo);
		
        return "member/memEdit";

	}
	
	
	@RequestMapping(value="/member/edit.do",method=RequestMethod.POST)
	public String edit(MemberVo vo){
		
//		//로그인 회원아이디와 변경할 회원아이디가 다르면 
//		HttpSession session =req.getSession();
//		MemberVo mvo=(MemberVo)session.getAttribute("loginUser");
//		if(!mvo.getMemId().equals(req.getParameter("memId"))) {
//			//여기다 어떻게 할지 구현
//			//여기선 오류를 일부러 발생시키기에 return을 넣을 필요가 없다.
//			throw new RuntimeException("로그인한 사용자와 다른 회원 정보는 변경 불가");
//			
//			//예외를 발생시킬것이 아니라면
//			//일단 아래쪽 코드를 진행못하게 return으로 막는 것이 중요하다.
//			//return;
//		}
		//----------------------------------------
		
		int num = memberService.updatetMember(vo);
		
		//resp.sendRedirect("이동할 사이트 주소"); 명령을 사용하여,
		///웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송
		return "redirect:/member/list.do";
		

	}
	
	@RequestMapping(value="/member/del.do",method=RequestMethod.GET)
	public String del(String memId) {
		
		
		
		
		int num = memberService.delMember(memId);
		
	
		return "redirect:/member/list.do";
		

	}
	
	
	
	
	

}
