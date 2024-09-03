package com.yedam.vo;

import java.io.PrintWriter;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;

import lombok.Data;

//lombok 활용 : getter, setter, toString, 메소드 생성.
//lombok 설치, 라이브러리 pom에 추가.\
@Data
public class MemberVO  {
	private String memberId;
	private String memberName;
	private String password;
	private String email;
	private String authority;
	private Date   craetionDate;
	

}
