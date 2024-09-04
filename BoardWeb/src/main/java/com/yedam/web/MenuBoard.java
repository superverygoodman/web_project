package com.yedam.web;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.AddFormControl;
import com.yedam.control.AddMemberControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.GetMemberControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModBoardControl;
import com.yedam.control.ModFormControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyMemberControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveMemberControl;
import com.yedam.control.indexControll;
import com.yedam.control.introControll;

//회원관련 메뉴와 컨트롤 등록. 팀원1 팀장
public class MenuBoard {
	private static MenuBoard instance = new MenuBoard();
	
	private MenuBoard() {}
	
	public static MenuBoard getInstance () {
		return instance;
	}
	
	public Map<String, Control> menuMap() {
		Map<String, Control> menu = new HashMap();
		menu.put("/boardList.do", new BoardListControl());
		menu.put("/getBoard.do", new BoardControl());
		menu.put("/modifyBoard.do", new ModBoardControl());
		menu.put("/modifyControl.do", new ModifyBoardControl());
		menu.put("/removeBoard.do", new RemoveBoardControl());
		return menu;
	}
	
	
}
