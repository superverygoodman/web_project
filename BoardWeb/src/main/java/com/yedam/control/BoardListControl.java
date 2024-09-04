package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "hello");
		String page = request.getParameter("page");
		page = page == null ? "1" : page; //페이지 값이 없을경우엔 1페이지로
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		request.setAttribute("list", list);
		
		int totalCnt = svc.getTotalCnt();
		PageDTO paging = new PageDTO(Integer.parseInt(page),totalCnt);
		request.setAttribute("paging", paging);
		
		
		RequestDispatcher rd = 	request.getRequestDispatcher("WEB-INF/board/boardList.jsp");
		rd.forward(request, response);
		
	}

}
