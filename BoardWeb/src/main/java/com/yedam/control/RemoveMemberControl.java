package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class RemoveMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		
		if(svc.removeMember(id)) {
			response.sendRedirect("memberList.do");
			} else {
				request.setAttribute("msg", "삭제실패!");
				request.getRequestDispatcher("WEB-INF/html/memberInfo.jsp");
			}
		}

	}


