package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;
//기능의 구현
public class MemberSeriveImpl implements MemberService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	
	
	@Override
	public List<MemberVO> getMembers() {
		return mapper.memberList();
	}
	
	
}
