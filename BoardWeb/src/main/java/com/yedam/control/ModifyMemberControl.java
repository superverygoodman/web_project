package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 4개값을 일거엇 db반영 ->목록으로 이동
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pass");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		
		member.setMemberId(id);
		member.setPassword(pw);
		member.setEmail(email);
		member.setMemberName(name);
		
		MemberService svc = new MemberServiceImpl();
		
		if(svc.modifyMember(member)) {
			System.out.println("값이 변경!");
			response.sendRedirect("memberList.do");
			
		} else {
			request.setAttribute("msg", "등록중 오류가 있습니다/");
			request.getRequestDispatcher("html/modifyForm.tiles").forward(request, response);
		}
		
	}

}
