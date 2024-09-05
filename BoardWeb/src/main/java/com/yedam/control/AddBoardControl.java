package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// application/x-www-form-urlencoded => key=value&key = value%....
		// multipart/from-data               => key=value...
		//multipart 요철을 처리. 서버의 위치(images) 파일복사.
		String saveDir = request.getServletContext().getRealPath("images");
		int maxSize = 5*1024*1024;// 5MB
		MultipartRequest mr;
		mr = new MultipartRequest(request, // 1.요청(request 정보)
				                  saveDir, // 2.파일저장경로
				                  maxSize, // 3.최대파일크기
				                  "utf-8",  // 4.인코딩
				                  new DefaultFileRenamePolicy() //리네임정책
				                  );
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("srcImage");//리네임된이름을 가져옴
		
		
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImage(img);
		
		BoardService svc = new BoardServiceImpl();
		svc.addBoard(board);
		response.sendRedirect("boardList.do");
		
		
	}

}
