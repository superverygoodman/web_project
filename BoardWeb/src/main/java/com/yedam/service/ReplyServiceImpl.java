package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(SearchDTO search) {
//		return mapper.selectList(bno); 기존 사용
//		return mapper.selectListPaging(search);
		return mapper.selectList(search.getBoardNo());
	}
	@Override
	public boolean removeReply(int rno) {
		return mapper.deleteReply(rno)==1;
	}
	@Override
	public boolean removeReplys(String[] array) {
		return mapper.deleteReplys(array) > 0;
	}
	@Override
	public boolean addReply(ReplyVO rvo) {
		int rno = mapper.selectKey();
		rvo.setReplyNo(rno);
		return mapper.insertReply(rvo) == 1;
	}
	@Override
	public int getReplyCount(int bno) {
		return mapper.selectReplyCount(bno);
	}
	@Override
	public boolean addEvent(SearchDTO event) {
		// TODO Auto-generated method stub
		return mapper.insertEvent(event)==1;
	}
	@Override
	public List<Map<String, Object>> eventList() {
		// TODO Auto-generated method stub
		return mapper.selectEvent();
	}
	@Override
	public boolean removeEvent(SearchDTO event) {
		// TODO Auto-generated method stub
		return mapper.deleteEvent(event)==1;
	}
}
