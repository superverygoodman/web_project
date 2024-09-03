package com.yedam.web;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.AddFormControl;
import com.yedam.control.AddMemberControl;
import com.yedam.control.GetMemberControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModFormControl;
import com.yedam.control.ModifyMemberControl;
import com.yedam.control.RemoveMemberControl;
import com.yedam.control.indexControll;
import com.yedam.control.introControll;

public class MenuMember {
	private static MenuMember instance = new MenuMember();
	private MenuMember() {}
	public static MenuMember getInstance () {
		return instance;
	}
	
	
	public Map<String, Control> menuMap() {
		Map<String, Control> menu = new HashMap();
		menu.put("/addMember.do", new AddMemberControl());  //회원등록처리
		menu.put("/addForm.do", new AddFormControl()); //회원등록페이지.
		menu.put("/intro.do", new introControll());
		menu.put("/index.do", new indexControll());
		menu.put("/memberList.do", new MemberListControl()); 
		menu.put("/getMember.do", new GetMemberControl()); // 회원아이디를 기준으로 상세조회;
		menu.put("/modifyForm.do", new ModFormControl());  //수정화면 호출
		menu.put("/modifyMember.do", new ModifyMemberControl()); //수정처리
		menu.put("/removeMember.do", new RemoveMemberControl());

		return menu;
	}
}
