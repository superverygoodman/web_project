package com.yedam.web;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ModBoardControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.RemoveReplysControl;
import com.yedam.control.ReplyListControl;

//댓글관련 메뉴
public class MenuReply {
	private static MenuReply instance = new MenuReply();
	
	private MenuReply() {}
	
	public static MenuReply getInstance () {
		return instance;
	}
	
	public Map<String, Control> menuMap() {
		Map<String, Control> menu = new HashMap();
		
		//댓글의 목록을 json형식으로 출력하는 페이지.
		menu.put("/replyList.do", new ReplyListControl());
		//삭제컨트롤
		menu.put("/removeReply.do", new RemoveReplyControl());
		menu.put("/removeReplys.do", new RemoveReplysControl());
		menu.put("/addReply.do", new AddReplyControl());
		return menu;
	}
	
	
}
