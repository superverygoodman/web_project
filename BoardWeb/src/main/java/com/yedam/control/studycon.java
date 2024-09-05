package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class studycon implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "4";
		String sc = "T";
		String kw = "java";
		
		
		request.setAttribute("page", page);
		request.setAttribute("searchCondition", sc);
		request.setAttribute("keyword", kw);
		
		request.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(request, response);

	}

}
