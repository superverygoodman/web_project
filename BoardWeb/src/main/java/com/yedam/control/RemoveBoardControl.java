package com.yedam.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		String page = request.getParameter("page");
//		BoardService bsv = new BoardServiceImpl();
//		if (bsv.removeBoard(bno)) {
//			response.sendRedirect("boardList.do?page="+page);
//		} else {
//			System.out.println("실패!");
//		}
		
		
		//bno (글삭제용도)
		String bno = request.getParameter("bno");
		String page = request.getParameter("page");
		//로그인정보 확인
		
		HttpSession session = request.getSession();
		String logid = (String) session.getAttribute("logid");
		
		String sc = request.getParameter("searchCondition");
		String kw = request.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		
		//로그인정보가 없거나 로그인정보와 작성자가 다르면 ..삭제불가..
		if(logid== null || !logid.equals(board.getWriter())) {
			request.setAttribute("message", "삭제권한이 없습니다.");
			request.setAttribute("board", board);
			request.setAttribute("page", page);
			request.setAttribute("bno", bno);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/board.tiles");
			rd.forward(request, response);
			
			return;
		}
		
		//게시글 삭제
		if (svc.removeBoard(Integer.parseInt(bno))) {
			response.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}
		
		
		
		}

}
