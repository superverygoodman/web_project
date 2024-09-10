package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int bno);
	boolean removeReply(int rno);
	boolean removeReplys(String[] array);
	boolean addReply(ReplyVO rvo);

}
