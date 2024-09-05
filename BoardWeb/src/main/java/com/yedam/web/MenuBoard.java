package com.yedam.web;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ModBoardControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.studycon;

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
		menu.put("/removeBoard.do", new RemoveBoardControl());
		
		//등록(화면,기능)
		menu.put("/addBoardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new AddBoardControl());
		//수정버튼
		menu.put("/modifyBoard.do", new ModBoardControl());
		menu.put("/modifyControl.do", new ModifyBoardControl());
		
		menu.put("/study.do", new studycon());
		return menu;
	}
	
	
}
