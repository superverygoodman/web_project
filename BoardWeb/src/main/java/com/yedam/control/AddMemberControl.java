package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberControl implements Control  {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		String id = request.getParameter("id");//사용자의 요청정보중에서 id값을 읽ㄱ도로함
		String name = request.getParameter("name");
		String pw = request.getParameter("pass");
		String mail = request.getParameter("email"); // input태그의 name 속성
		
		MemberVO mvo = new MemberVO();
		
		
		mvo.setMemberId(id);
		mvo.setMemberName(name);
		mvo.setPassword(pw);
		mvo.setEmail(mail);
		
		MemberService svc = new MemberServiceImpl();
		//회원등록이 정상적일 경우 => 회원목록 페이지 출력
		//화원등록이 비정적일 경우 => 회원등록 페이지 이동(msg 전달)
		// 현재 페이지 : addMember.do -> 페이지 재지정 방식 1) forwarding(파라미터전달) 2) redirect(파라미터전달x)
		
		if(svc.addMember(mvo)) {
			//PrintWriter out = response.getWriter(); 
			//out.print("등록됨");
			response.sendRedirect("memberList.do");
		} else {
			request.setAttribute("message", "등록중에 오류가 있습니다.");
			request.getRequestDispatcher("WEB-INF/html/addForm.jsp").forward(request, response);
			
			
		}
	}
}
