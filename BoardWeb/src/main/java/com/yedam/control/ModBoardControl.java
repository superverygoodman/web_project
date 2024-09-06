package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		String page = request.getParameter("page");
		String sc = request.getParameter("searchCondition");
		String kw = request.getParameter("keyword");
			
		BoardService bsv = new BoardServiceImpl();
		BoardVO board = bsv.getBoard(Integer.parseInt(bno));
		request.setAttribute("board", board);
		System.out.println(sc);
		System.out.println(kw);
		request.setAttribute("sc",sc);
		request.setAttribute("kw", kw);
		request.setAttribute("page",page);
		
		request.getRequestDispatcher("board/boardInfo.tiles").forward(request, response);
		
		
	}

}
