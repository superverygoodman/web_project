package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String page = request.getParameter("page");
		BoardService bsv = new BoardServiceImpl();
		if (bsv.removeBoard(bno)) {
			response.sendRedirect("boardList.do?page="+page);
		} else {
			System.out.println("실패!");
		}
	}

}
