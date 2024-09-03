package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;


//클라이언트 -> 페이지요청 -> 웹서버 -> 서블릿컨테이너(톰캣):memberList.action ->
//-> init -> request, response -> service ->

//init() -> service() -> destroy() :서블릿의 생명주기

@WebServlet("/memberList.action")

public class MemberListServ extends HttpServlet {
	
	
	public MemberListServ () {
		System.out.println("MemberListServ 생성자 호출.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 호출.");
		resp.setContentType("text/html;charset=utf-8");
		
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		List<MemberVO> list = mapper.memberList();
		String str = "<ul>";
		for(MemberVO member : list) {
			str += "<li>" + member.getMemberId() +" : "+member.getMemberName()+ "</li>";
		}
		str += "</ul>";
		resp.getWriter().print(str);
	}
	
	@Override
	public void destroy() {
		System.out.println("destory 메소드 호출.");

	}
}
