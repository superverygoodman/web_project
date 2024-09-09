package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//댓글작성자, 원본글번호, 댓글내용
		response.setContentType("text/json;charset=utf-8");
		String bno = request.getParameter("bno");
		String replyer = request.getParameter("replyer");
		String reply = request.getParameter("reply");
		//retCode =>OK. retCode=NG
		ReplyService svc = new ReplyServiceImpl();
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		if(svc.addReply(rvo)) {
			//{"retCode" : "OK", ""}
			response.getWriter().print("{\"retCode\":\"OK\",\"retVal\":{\"replyDate\":\""+rvo.getReplyDate()
										+ " "}");
			
		} else {
			
			response.getWriter().print("{\"retCode\":\"NG\"}");
		}
		
	}

}
