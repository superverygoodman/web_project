package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(SearchDTO search);
	boolean removeReply(int rno);
	boolean removeReplys(String[] array);
	boolean addReply(ReplyVO rvo);
	
	//댓글건수
	int getReplyCount(int bno);
	
	//fullcalendar 관련 
	List<Map<String, Object>> eventList();
	boolean addEvent(SearchDTO event);
	boolean removeEvent(SearchDTO event);
	
	
}
