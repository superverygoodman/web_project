package com.yedam.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String page = request.getParameter("page");
		String sc = request.getParameter("sc");
		String kw = request.getParameter("kw");

		System.out.println(page);
		System.out.println(bno);
		BoardService bsv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		if(bsv.modifyBoard(board)) {
//			request.setAttribute("page", page);
//			request.setAttribute("searchCondition", sc);
//			request.setAttribute("keyword", kw);
//			
//			request.getRequestDispatcher("WEB-INF/board/boardList.jsp").forward(request, response);
			request.setAttribute("page", page);
			response.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		} else {
			request.setAttribute("msg", "변경이 실패했습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/board/boardInfo.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
