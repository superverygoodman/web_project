package com.yedam.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDir = request.getServletContext().getRealPath("images");
		int maxSize = 5*1024*1024;// 5MB
		MultipartRequest mr;
		mr = new MultipartRequest(request, // 1.요청(request 정보)
				                  saveDir, // 2.파일저장경로
				                  maxSize, // 3.최대파일크기
				                  "utf-8",  // 4.인코딩
				                  new DefaultFileRenamePolicy() //리네임정책
				                  );
		
		String bno = mr.getParameter("bno");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String page = mr.getParameter("page");
		String sc = mr.getParameter("sc");
		String kw = mr.getParameter("kw");
		String img =mr.getFilesystemName("srcImage");

		BoardService bsv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		board.setImage(img);
		
		
		
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
			RequestDispatcher rd = request.getRequestDispatcher("board/boardInfo.tiles");
			rd.forward(request, response);
			
		}
		
		
	}

}
