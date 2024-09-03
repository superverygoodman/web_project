package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class AddMemberServlet
 */
@WebServlet("/AddMemberServlet")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
	
    public AddMemberServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		String id = request.getParameter("id");//사용자의 요청정보중에서 id값을 읽ㄱ도로함
		String name = request.getParameter("name");
		String pw = request.getParameter("pass");
		String mail = request.getParameter("email"); // input태그의 name 속성
		
		MemberVO mvo = new MemberVO();
		
		
		mvo.setMemberId(id);
		mvo.setMemberName(name);
		mvo.setPassword(pw);
		mvo.setEmail(mail);
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		if(mapper.insertMember(mvo) == 1) {
			PrintWriter out = response.getWriter(); 
			out.print("등록됨");
		}

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
